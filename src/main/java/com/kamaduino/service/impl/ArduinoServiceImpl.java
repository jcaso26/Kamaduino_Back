package com.kamaduino.service.impl;

import com.kamaduino.converter.SensorDataConverter;
import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.service.ArduinoService;
import com.kamaduino.service.SensorService;
import com.kamaduino.utils.SensorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

@Service
public class ArduinoServiceImpl implements ArduinoService {

    @Autowired
    SensorService sensorService;

    @Value("${arduino.data.path}")
    private String arduinoDataPath;

    @Override
    public Map<String,Map<LocalTime,List<SensorDataDTO>>> readDataFromFileToBBDD() throws KamaduinoException {
        /**
         * Lista Sensores con sus valores
         */
        List<SensorDataDTO> sensorList;

        /**
         * Mapa Hora - Valores de los Sensores
         */
        Map<LocalTime, List<SensorDataDTO>> mapaHorario;
        Map<LocalTime, List<SensorDataDTO>> mapaHorarioOrdenado;

        /**
         * Mapa Fecha - Valores por hora
         */
        Map<String,Map<LocalTime,List<SensorDataDTO>>> mapaCompleto = new HashMap<>();
        Map<String,Map<LocalTime,List<SensorDataDTO>>> mapaCompletoOrdenado = null;

        FileReader fr;
        BufferedReader br;
        String[] data;
        String date;

        File dir = new File(this.arduinoDataPath);
        File[] ficheros = dir.listFiles();

        if(ficheros.length > 0) {
            for (int i = 0; i < ficheros.length; i++) {
                System.out.println(ficheros[i].getName());
                mapaHorario = new HashMap<>();

                //La fecha la cogemos del nombre del fichero quitandole la extension
                String fecha = String.valueOf(ficheros[i].getName().substring(0, ficheros[i].getName().lastIndexOf(".")));

                try {
                    fr = new FileReader(this.arduinoDataPath + ficheros[i].getName());
                    br = new BufferedReader(fr);
                    // Lectura del fichero
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        //Comprobamos comentarios
                        if (!linea.startsWith("--")) {
                            data = linea.split("#");
                            //Insertamos los valores de cada sensor
                            sensorList = new ArrayList<>();
                            //Fecha y hora de la lectura (Time) //TODO Posible mejora: cambiar String por Time/Date/Similares
                            date = fecha + " " + data[0];
                            //Insertamos los valores de cada sensor
                            sensorList.add(new SensorDataDTO(Double.valueOf(data[1]), date, SensorEnum.SENSOR_HUMEDAD_ARRIBA.getDescripcion()));
                            sensorList.add(new SensorDataDTO(Double.valueOf(data[2]), date, SensorEnum.SENSOR_TEMPERATURA_ARRIBA.getDescripcion()));
                            sensorList.add(new SensorDataDTO(Double.valueOf(data[3]), date, SensorEnum.SENSOR_HUMEDAD_ABAJO.getDescripcion()));
                            sensorList.add(new SensorDataDTO(Double.valueOf(data[4]), date, SensorEnum.SENSOR_TEMPERATURA_ABAJO.getDescripcion()));
                            sensorList.add(new SensorDataDTO(Double.valueOf(data[5]), date, SensorEnum.SENSOR_NIVEL_AGUA.getDescripcion()));

                            //Insertamos los valores de cada sensor en su horario
                            mapaHorario.put(LocalTime.parse(data[0]), sensorList);
                        }
                    }

                    fr.close();

                    //Insertamos el mapa completo, con la fecha, hora y valores leidos de cada sensor ordenado por hora
                    mapaHorarioOrdenado = new TreeMap<>(mapaHorario);
                    mapaCompleto.put(fecha, mapaHorarioOrdenado);

                } catch (FileNotFoundException e) {
                    throw new KamaduinoException(e.getMessage());
                } catch (IOException e1) {
                    throw new KamaduinoException(e1.getMessage());
                }
            }

            //Ordenamos el mapa por fechas
            mapaCompletoOrdenado = new TreeMap<>(mapaCompleto);

        }

        return mapaCompletoOrdenado;
    }

    @Override
    public void saveDataInBBDD(Map<String, Map<LocalTime, List<SensorDataDTO>>> dataMapFromFile) {
        Iterator<Map.Entry<String, Map<LocalTime, List<SensorDataDTO>>>> iterator = dataMapFromFile.entrySet().iterator();
        Iterator<Map.Entry<LocalTime, List<SensorDataDTO>>> iterator2;
        while (iterator.hasNext()) {
            Map.Entry<String, Map<LocalTime, List<SensorDataDTO>>> entry = iterator.next();
            iterator2 = entry.getValue().entrySet().iterator();
            while(iterator2.hasNext()){
                Map.Entry<LocalTime, List<SensorDataDTO>> entry2 = iterator2.next();
                for(SensorDataDTO sensor: entry2.getValue()){
                    //TODO LOGGER
                    sensorService.save(sensor);
                }
            }
        }
    }

    @Override
    public void readWriteDataBBDD() throws KamaduinoException {
        // 1. Leemos los ficheros y los pasamos a DTO
        Map<String,Map<LocalTime,List<SensorDataDTO>>> dataMap = this.readDataFromFileToBBDD();

        // 2. Si no hay errores, los guardamos en la base de datos y los borramos
        if(dataMap == null){
            throw new KamaduinoException("ERROR EN LOS FICHEROS DE DATOS"); //TODO
        } else if(dataMap.size() == 0 ) {
            throw new KamaduinoException("NO HAY DATOS PARA ALMACENAR"); //TODO
        }else{
            saveDataInBBDD(dataMap);
            //Eliminamos los ficheros
            File dir = new File(this.arduinoDataPath);
            File[] ficheros = dir.listFiles();
            for (int i = 0; i < ficheros.length; i++) {
                //TODO LOG FICHERO ELIMINADO
                ficheros[i].delete();
            }
        }
    }

    @Override
    public List<SensorDataDTO> readActualSensorData() throws KamaduinoException {
        List<SensorDataDTO> datosActuales = new ArrayList<>();
        String lastLine = null;
        String last, fileName;
        File dir = new File(this.arduinoDataPath);
        File file;
        BufferedReader br;
        String[] ficheros = dir.list();

        try {
            if(ficheros.length > 0){
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                for(int i=0; i<ficheros.length; i++){
                    file = new File(ficheros[i]);
                    fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
                    if(fileName.equals(dateFormat.format(date))){
                        br = new BufferedReader(new FileReader(this.arduinoDataPath + file));
                        last = br.readLine();
                        while (last != null) {
                            lastLine = last;
                            last = br.readLine();
                        }
                        break;
                    }
                }
            }
            else{
                //TODO ERRORES LOGGER
                throw new KamaduinoException("ERROR no ficheros");
            }
        } catch (IOException e) {
            //TODO ERRORES LOGGER
            e.printStackTrace();
        }

        datosActuales = SensorDataConverter.textToDTO(lastLine);

        return datosActuales;
    }
}
