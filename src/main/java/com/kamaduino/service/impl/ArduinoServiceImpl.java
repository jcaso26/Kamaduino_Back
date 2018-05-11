package com.kamaduino.service.impl;

import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.service.ArduinoService;
import com.kamaduino.utils.Sensor;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ArduinoServiceImpl implements ArduinoService {

    /**
     *  Instancia de la libreria para la conexion del arduino
     **/
    private PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();

    /**
     *
     **/
    private Map<Sensor,Double> dataMap;

    /**
     *
     **/
    @Value("${arduino.numero.sensores}")
    private int numSensores;

    @Value("${arduino.port}")
    private String arduinoPort;

    @Value("${arduino.dataRate}")
    private int dataRate;

    @Override
    public Map<Sensor,Double> readData() throws KamaduinoException {
        dataMap = new HashMap<>();
        try {

        this.arduino.arduinoRXTX(arduinoPort, dataRate, new SerialPortEventListener() {
            @Override
            //Si se recibe algun dato en el puerto serie, se ejecuta el siguiente metodo
            public void serialEvent(SerialPortEvent serialPortEvent) {
                try {
                /*
                Los datos en el puerto serie se envian caracter por caracter. Si se
                desea esperar a terminar de recibir el mensaje antes de imprimirlo,
                el metodo isMessageAvailable() devolvera TRUE cuando se haya terminado
                de recibir el mensaje, el cual podra ser impreso a traves del metodo
                printMessage()
                 */
                    if (arduino.isMessageAvailable()) {
                        //Se recibe el dato y se le asigna al jLabelAnswer
                        System.out.print("MENSAJE ARDUINO: " + arduino.printMessage());
                    }
                } catch (SerialPortException | ArduinoException ex) {
//                Logger.getLogger(rxtxExample.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        });
//        PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(numSensores, this.arduino);

            this.arduino.isMessageAvailable();
//            multi.dataReceptionCompleted();

            dataMap.put(Sensor.SENSOR_HUMEDAD_ARRIBA, this.readHumedadSuperior());
            dataMap.put(Sensor.SENSOR_HUMEDAD_ABAJO, this.readHumedadInferior());
            dataMap.put(Sensor.SENSOR_TEMPERATURA_ARRIBA, this.readTemperaturaSuperior());
            dataMap.put(Sensor.SENSOR_TEMPERATURA_ABAJO, this.readTemperaturaInferior());
            dataMap.put(Sensor.SENSOR_NIVEL_AGUA, this.readNivelAgua());
            this.arduino.killArduinoConnection();
        } catch(ArduinoException a){
            throw new KamaduinoException(a.getMessage());
        }catch (SerialPortException s){
            throw new KamaduinoException(s.getMessage());
        }
        return dataMap;
    }

    private Double readHumedadSuperior(){
        return 70.5;
    }

    private Double readHumedadInferior(){
        return 80.5;
    }

    private Double readTemperaturaSuperior(){
        return 25.5;
    }

    private Double readTemperaturaInferior(){
        return 22.5;
    }

    private Double readNivelAgua(){
        return 57.5;
    }
}
