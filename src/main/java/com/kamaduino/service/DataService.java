package com.kamaduino.service;

import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.exceptions.KamaduinoException;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface DataService {

    /**
     *
     * @return
     * @throws KamaduinoException
     */
    Map<String,Map<LocalTime,List<SensorDataDTO>>> readDataFromFileToBBDD() throws KamaduinoException;

    /**
     *
     * @param dataMapFromFile
     */
    void saveDataInBBDD(Map<String,Map<LocalTime,List<SensorDataDTO>>> dataMapFromFile);

    /**
     *
     * @throws KamaduinoException
     */
    void readWriteDataBBDD() throws KamaduinoException;

    /**
     *
     * @return
     * @throws KamaduinoException
     */
    List<SensorDataDTO> readActualSensorData() throws KamaduinoException;

    /**
     *
     * @param sensorId
     * @return
     * @throws KamaduinoException
     */
    List<SensorDataDTO> readSensorData(String sensorId) throws KamaduinoException;

}
