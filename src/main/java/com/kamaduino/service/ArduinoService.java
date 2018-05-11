package com.kamaduino.service;

import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.utils.Sensor;

import java.util.Map;

public interface ArduinoService {
    Map<Sensor,Double> readData() throws KamaduinoException;
}
