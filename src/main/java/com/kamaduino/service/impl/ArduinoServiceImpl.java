package com.kamaduino.service.impl;

import com.kamaduino.dto.ConfigSensorDTO;
import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.repository.ConfigSensorRepository;
import com.kamaduino.service.ArduinoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArduinoServiceImpl implements ArduinoService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ConfigSensorRepository configSensorRepository;

    @Override
    public void setConfigSensorById(ConfigSensorDTO configSensor) throws KamaduinoException {

    }

    @Override
    public void setConfigAllSensor(List<ConfigSensorDTO> listaConfig) throws KamaduinoException {
        for(ConfigSensorDTO configSensorDTO : listaConfig){
            //Si existe, lo actualizamos
            if(configSensorRepository.existeConfigSensorById(configSensorDTO.getIdSensor())){
//                    configSensorRepository.insert(configSensorDTO);
            }
            else{
//                configSensorRepository.update(configSensorDTO);
            }

        }
    }

    @Override
    public List<ConfigSensorDTO> getConfigAllSensor() throws KamaduinoException {
        return null;
    }
}
