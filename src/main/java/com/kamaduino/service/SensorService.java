package com.kamaduino.service;

import com.kamaduino.dto.SensorDataDTO;

import java.util.List;

public interface SensorService {

    void save(SensorDataDTO sensorDTO);

    List<SensorDataDTO> getAllData();

}
