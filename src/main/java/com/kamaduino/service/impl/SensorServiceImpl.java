package com.kamaduino.service.impl;

import com.kamaduino.converter.SensorDataConverter;
import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.entity.SensorData;
import com.kamaduino.repository.SensorDataRepository;
import com.kamaduino.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService{

    @Autowired
    SensorDataRepository sensorDataRepository;

    @Override
    public void save(SensorDataDTO sensorDataDTO) {
        SensorData sensorData = SensorDataConverter.dtoToEntity(sensorDataDTO);
        sensorDataRepository.save(sensorData);
    }

    @Override
    public List<SensorDataDTO> getAllData() {
        return null;
    }

}
