package com.kamaduino.listener;

import com.kamaduino.utils.StringsUtil;
import com.kamaduino.utils.Utils;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArduinoReadDataListener implements Runnable {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     *  Instancia de la libreria para la conexion del arduino
     */
    PanamaHitek_Arduino arduino;

    /**
     * Boolean para parar el hilo
     */
    private boolean continueRead;

    /**
     * Puerto comunicación Arduino
     */
    private String arduinoPort;

    /**
     * Velocidad de comunicación con el Arduino
     */
    private int dataRate;

    /**
     * Path del fichero donde se guardan los datos de los sensores
     */
    private String arduinoDataFilePath;

    /**
     * Clase DateFormat para el formato horario
     */
    private DateFormat hourFormat;

    /**
     * Clase DateFormat para el formato de fecha
     */
    private DateFormat dateFormat;

    public ArduinoReadDataListener(PanamaHitek_Arduino arduino, String arduinoPort, int dataRate, String filePath) {
        continueRead = true;
        this.arduino = arduino;
        this.arduinoPort = arduinoPort;
        this.dataRate = dataRate;
        this.arduinoDataFilePath = filePath;
        hourFormat = new SimpleDateFormat(StringsUtil.TIME_PATTERN);
        dateFormat = new SimpleDateFormat(StringsUtil.DATE_PATTERN);
    }

    @Override
    public void run() {
        while(continueRead) {
            try {
                Thread.sleep(500);
                //Si se recibe algun dato en el puerto serie, se ejecuta el siguiente metodo
                this.arduino.arduinoRXTX(this.arduinoPort, this.dataRate, serialPortEvent -> {
                    try {
                        if (arduino.isMessageAvailable()) {
                            //Se recibe el dato
                            this.escribirFichero(arduino.printMessage());
                        }
                    } catch (SerialPortException | ArduinoException ex) {
                        LOGGER.error(ex.getMessage());
//                        ex.printStackTrace();
                    }
                });
            } catch (ArduinoException a) {
                LOGGER.error(a.getMessage());
//                a.getMessage();
            } catch (InterruptedException e) {
//                e.printStackTrace();
                LOGGER.error(e.getMessage());
            }
        }
        try {
            this.arduino.killArduinoConnection();
        } catch (ArduinoException e) {
//            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * Escribe en el fichero los datos leidos de los sensores de arduino
     * @param mensajeArduino Datos de la lectura del arduino
     */
    private void escribirFichero(String mensajeArduino){
        String cadenaFinal;

        Date date = new Date();
        cadenaFinal = hourFormat.format(date) + StringsUtil.TOKEN + mensajeArduino + "\n";
        File fileData = new File(this.arduinoDataFilePath + dateFormat.format(date) + StringsUtil.TXT_EXTENSION);
        BufferedWriter bw;

        try {
            //Si el fichero existe, añadimos nueva linea
            if(fileData.exists()){
                bw = new BufferedWriter(new FileWriter(fileData, true));
            } else {
                Object[] array = {fileData.getName()};
                LOGGER.info(Utils.getMessage(StringsUtil.FICHERO_CREADO, array));
                bw = new BufferedWriter(new FileWriter(fileData));
            }
            bw.write(cadenaFinal);
            bw.close();
        } catch (IOException e) {
//            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }
}