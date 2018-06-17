package com.kamaduino.service;

import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.exceptions.KamaduinoException;

import java.util.List;

public interface SensorService {

    void save(SensorDataDTO sensorDTO);

//    List<SensorDataDTO> getAllData();

    List<SensorDataDTO> getDataBySensorId(String sensorId) throws KamaduinoException;


}
