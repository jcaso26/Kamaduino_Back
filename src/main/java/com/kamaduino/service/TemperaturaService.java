package com.kamaduino.service;

import com.kamaduino.dto.TemperaturaDTO;

import java.util.List;

public interface TemperaturaService {
    void save(TemperaturaDTO temperaturaDto);
    List<TemperaturaDTO> getAllData();
}
