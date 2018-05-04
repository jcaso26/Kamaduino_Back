package com.kamaduino.service.impl;

import com.kamaduino.converter.HumedadConverter;
import com.kamaduino.dto.HumedadDTO;
import com.kamaduino.repository.HumedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kamaduino.service.HumedadService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HumedadServiceImpl implements HumedadService {

    @Autowired
    HumedadRepository humedadRepository;

    @Override
    public void save(HumedadDTO humedadDto) {
        //TODO
//        humedadRepository.save(hume)
    }

    @Override
    public List<HumedadDTO> getAllData() {
        return humedadRepository.findAll().stream().map(HumedadConverter::entityToDTO).collect(Collectors.toList());
    }

}
