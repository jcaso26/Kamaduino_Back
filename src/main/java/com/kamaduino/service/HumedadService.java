package com.kamaduino.service;

import com.kamaduino.dto.HumedadDTO;

import java.util.List;

public interface HumedadService {
//    HumedadDTO getHumedadById(Integer userId);
    void save(HumedadDTO humedadDto);
    List<HumedadDTO> getAllData();
}
