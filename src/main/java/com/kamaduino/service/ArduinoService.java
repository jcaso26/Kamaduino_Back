package com.kamaduino.service;

import com.kamaduino.dto.ConfigSensorDTO;
import com.kamaduino.exceptions.KamaduinoException;

import java.util.List;

public interface ArduinoService {

    void setConfigSensorById(ConfigSensorDTO configSensor) throws KamaduinoException;

    void setConfigAllSensor(List<ConfigSensorDTO> listaConfig) throws KamaduinoException;

    List<ConfigSensorDTO> getConfigAllSensor() throws KamaduinoException;
}
