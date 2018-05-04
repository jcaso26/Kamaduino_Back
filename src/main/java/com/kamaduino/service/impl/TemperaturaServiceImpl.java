package com.kamaduino.service.impl;

import com.kamaduino.converter.TemperaturaConverter;
import com.kamaduino.dto.TemperaturaDTO;
import com.kamaduino.repository.TemperaturaRepository;
import com.kamaduino.service.TemperaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperaturaServiceImpl implements TemperaturaService {

    @Autowired
    TemperaturaRepository temperaturaRepository;

    @Override
    public void save(TemperaturaDTO temperaturaDto) {
        //TODO
    }

    @Override
    public List<TemperaturaDTO> getAllData() {
        return temperaturaRepository.findAll().stream().map(TemperaturaConverter::entityToDTO).collect(Collectors.toList());
    }
}
