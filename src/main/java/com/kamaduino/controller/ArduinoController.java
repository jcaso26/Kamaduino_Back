package com.kamaduino.controller;

import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.service.ArduinoService;
import com.kamaduino.utils.Constantes;
import com.kamaduino.utils.Sensor;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ArduinoController {

    @Autowired
    ArduinoService arduinoService;

    @RequestMapping(value = Constantes.READ_DATA_ARDUINO, method = RequestMethod.GET)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Error comunicación Arduino"), @ApiResponse(code = 200, message = "Lectura Correcta") })
    public ResponseEntity<Map<Sensor,Double>> readDataFromArduino(){
        Map<Sensor,Double> dataMap = null;
        try {
            dataMap = arduinoService.readData();
        } catch (KamaduinoException k) {
            k.getMessage();
            //TODO LOGGER MENSAJE
            return new ResponseEntity<>(dataMap, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dataMap, HttpStatus.OK);
    }


}
