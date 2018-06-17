package com.kamaduino.service.impl;

import com.kamaduino.converter.SensorDataConverter;
import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.service.DataService;
import com.kamaduino.service.SensorService;
import com.kamaduino.utils.ErrorEnum;
import com.kamaduino.utils.SensorEnum;
import com.kamaduino.utils.StringsUtil;
import com.kamaduino.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

@Service
public class DataServiceImpl implements DataService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
        Date dateFinish;

        File dir = new File(this.arduinoDataPath);
        File[] ficheros = dir.listFiles();

        if(ficheros.length > 0) {
            for (int i = 0; i < ficheros.length; i++) {
                System.out.println(ficheros[i].getName());
                mapaHorario = new HashMap<>();

                //La fecha la cogemos del nombre del fichero quitandole la extension
                String fecha = String.valueOf(ficheros[i].getName().substring(0, ficheros[i].getName().lastIndexOf(StringsUtil.PUNTO)));

                try {
                    fr = new FileReader(this.arduinoDataPath + ficheros[i].getName());
                    br = new BufferedReader(fr);
                    // Lectura del fichero
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        //Comprobamos comentarios
                        if (!linea.startsWith(StringsUtil.COMMENT_FILE)) {
                            data = linea.split(StringsUtil.TOKEN);
                            //Insertamos los valores de cada sensor
                            sensorList = new ArrayList<>();
                            date = fecha + StringsUtil.ESPACIO + data[0];
                            //Insertamos los valores de cada sensor
                            //TODO CAMBIADO A FOR. PROBAR
                            dateFinish = new SimpleDateFormat(StringsUtil.DATE_TIME_PATTERN).parse(date);
                            for(int j = 1; j < data.length; j++){
                                sensorList.add(new SensorDataDTO(Double.valueOf(data[j]), dateFinish, SensorEnum.getDescripcionFromValue(j)));
                            }
//                            sensorList.add(new SensorDataDTO(Double.valueOf(data[1]), dateFinish, SensorEnum.SENSOR_HUMEDAD_ARRIBA.getDescripcion()));
//                            sensorList.add(new SensorDataDTO(Double.valueOf(data[2]), dateFinish, SensorEnum.SENSOR_TEMPERATURA_ARRIBA.getDescripcion()));
//                            sensorList.add(new SensorDataDTO(Double.valueOf(data[3]), dateFinish, SensorEnum.SENSOR_HUMEDAD_ABAJO.getDescripcion()));
//                            sensorList.add(new SensorDataDTO(Double.valueOf(data[4]), dateFinish, SensorEnum.SENSOR_TEMPERATURA_ABAJO.getDescripcion()));
//                            sensorList.add(new SensorDataDTO(Double.valueOf(data[5]), dateFinish, SensorEnum.SENSOR_NIVEL_AGUA.getDescripcion()));

                            //Insertamos los valores de cada sensor en su horario
                            mapaHorario.put(LocalTime.parse(data[0]), sensorList);
                        }
                    }

                    fr.close();

                    //Insertamos el mapa completo, con la fecha, hora y valores leidos de cada sensor ordenado por hora
                    mapaHorarioOrdenado = new TreeMap<>(mapaHorario);
                    mapaCompleto.put(fecha, mapaHorarioOrdenado);

                } catch (FileNotFoundException e) {
                    throw new KamaduinoException(ErrorEnum.ERROR_LECTURA_ESCRITURA_FICHEROS, e.getMessage());
                } catch (IOException e1) {
                    throw new KamaduinoException(ErrorEnum.ERROR_LECTURA_ESCRITURA_FICHEROS, e1.getMessage());
                } catch (ParseException p){
                    throw new KamaduinoException(ErrorEnum.ERROR_PARSE_FECHAS, p.getMessage());
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
            int contador = 0;
            while(iterator2.hasNext()){
                Map.Entry<LocalTime, List<SensorDataDTO>> entry2 = iterator2.next();
                for(SensorDataDTO sensor: entry2.getValue()){
                    contador++;
                    sensorService.save(sensor);
                }
            }

            Object[] array = {contador};
            LOGGER.info(Utils.getMessage(StringsUtil.FICHEROS_ALMACENADOS, array));
        }
    }

    @Override
    public void readWriteDataBBDD() throws KamaduinoException {
        // 1. Leemos los ficheros y los pasamos a DTO
        Map<String,Map<LocalTime,List<SensorDataDTO>>> dataMap = this.readDataFromFileToBBDD();

        // 2. Si no hay errores, los guardamos en la base de datos y los borramos
        if(dataMap == null){
            throw new KamaduinoException(ErrorEnum.ERROR_LECTURA_FICHEROS_HISTORICO);
        } else if(dataMap.size() == 0 ) {
            throw new KamaduinoException(ErrorEnum.ERROR_NO_DATA_EN_FICHEROS);
        }else{
            saveDataInBBDD(dataMap);
            //Eliminamos los ficheros
            File dir = new File(this.arduinoDataPath);
            File[] ficheros = dir.listFiles();
            for (int i = 0; i < ficheros.length; i++) {
                Object[] array = {ficheros[i].getName()};
                LOGGER.info(Utils.getMessage(StringsUtil.FICHERO_ELIMINADO, array));
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
                SimpleDateFormat dateFormat = new SimpleDateFormat(StringsUtil.DATE_PATTERN);
                for(int i=0; i<ficheros.length; i++){
                    file = new File(ficheros[i]);
                    fileName = file.getName().substring(0, file.getName().lastIndexOf(StringsUtil.PUNTO));
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
                throw new KamaduinoException(ErrorEnum.ERROR_LECTURA_FICHEROS_HISTORICO);
            }
        } catch (IOException e) {
            throw new KamaduinoException(ErrorEnum.ERROR_LECTURA_ESCRITURA_FICHEROS, e.getMessage());
        }

        datosActuales = SensorDataConverter.textToDTO(lastLine);

        return datosActuales;
    }

    @Override
    public List<SensorDataDTO> readSensorData(String sensorId) throws KamaduinoException {
        return sensorService.getDataBySensorId(sensorId);
    }
}
