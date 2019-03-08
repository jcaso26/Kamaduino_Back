package com.kamaduino.controller;

import com.kamaduino.dto.ConfigSensorDTO;
import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.service.ArduinoService;
import com.kamaduino.utils.EndPoints;
import com.kamaduino.utils.StringsUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArduinoController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArduinoService arduinoService;

    @RequestMapping(value = EndPoints.WRITE_CONFIG_DATA_ARDUINO, method = RequestMethod.POST)
    @ApiOperation(value = StringsUtil.ARDUINO_CTRL_VALUE_WRITE_CONFIG_DATA_ARDUINO, notes = StringsUtil.ARDUINO_CTRL_NOTES_WRITE_CONFIG_DATA_ARDUINO)
    public ResponseEntity<HttpStatus> writeDataToArduino(@RequestBody List<ConfigSensorDTO> listConfigSensor){
        try{
            arduinoService.setConfigAllSensor(listConfigSensor);
        } catch (KamaduinoException k){
            LOGGER.error(k.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = EndPoints.UPDATE_CONFIG_DATA_ARDUINO_BY_ID, method = RequestMethod.POST, produces="application/json", consumes="application/json")
    @ApiOperation(value = StringsUtil.ARDUINO_CTRL_VALUE_UPDATE_CONFIG_DATA_ARDUINO_BY_ID, notes = StringsUtil.ARDUINO_CTRL_NOTES_UPDATE_CONFIG_DATA_ARDUINO_BY_ID)
    public ResponseEntity<HttpStatus> writeDataToArduinoById(@RequestBody ConfigSensorDTO configSensor){
        try{
            arduinoService.setConfigSensorById(configSensor);
        } catch (KamaduinoException k){
            LOGGER.error(k.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = EndPoints.READ_CONFIG_DATA_ARDUINO, method = RequestMethod.GET)
    @ApiOperation(value = StringsUtil.ARDUINO_CTRL_VALUE_READ_CONFIG_DATA_ARDUINO, notes = StringsUtil.ARDUINO_CTRL_NOTES_READ_CONFIG_DATA_ARDUINO)
    public ResponseEntity<List<ConfigSensorDTO>> readDataFromArduino(){
        List<ConfigSensorDTO> listConfigData = null;
        try{
            arduinoService.getConfigAllSensor();
        }catch (KamaduinoException k){
            LOGGER.error(k.getMessage());
        }
        return new ResponseEntity<>(listConfigData, HttpStatus.OK);
    }





}
