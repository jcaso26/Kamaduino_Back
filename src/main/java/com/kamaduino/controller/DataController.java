package com.kamaduino.controller;

import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.service.DataService;
import com.kamaduino.utils.EndPoints;
import com.kamaduino.utils.SensorEnum;
import com.kamaduino.utils.StringsUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DataService dataService;

    @RequestMapping(value = EndPoints.READ_ACTUAL_SENSOR_DATA, method = RequestMethod.GET)
    @ApiOperation(value = StringsUtil.DATA_CTRL_VALUE_READ_ACTUAL_SENSOR_DATA, notes = StringsUtil.DATA_CTRL_NOTES_READ_ACTUAL_SENSOR_DATA)
    public ResponseEntity<List<SensorDataDTO>> readActualSensorData(){
        List<SensorDataDTO> listaSensorData;
        try {
            listaSensorData = dataService.readActualSensorData();
        } catch (KamaduinoException k) {
            LOGGER.error(k.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaSensorData, HttpStatus.OK);
    }

    @RequestMapping(value = EndPoints.READ_FILE_DATA_WRITE_BBDD, method = RequestMethod.GET)
    @ApiOperation(value = StringsUtil.DATA_CTRL_VALUE_READ_FILE_DATA_WRITE_BBDD, notes = StringsUtil.DATA_CTRL_NOTES_READ_FILE_DATA_WRITE_BBDD)
    public ResponseEntity<HttpStatus> readDataFromFileToBBDD() {
        try {
            dataService.readWriteDataBBDD();
        } catch (KamaduinoException k) {
            LOGGER.error(k.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = EndPoints.READ_DATA_SENSOR, method = RequestMethod.GET)
    @ApiOperation(value = StringsUtil.DATA_CTRL_VALUE_READ_DATA_SENSOR, notes = StringsUtil.DATA_CTRL_NOTES_READ_DATA_SENSOR)
    public ResponseEntity<List<SensorDataDTO>> readDataSensorFromBBDD(@RequestParam("sensorId")SensorEnum sensorId) {
        List<SensorDataDTO> listaSensorData;
        try {
            listaSensorData = dataService.readSensorData(sensorId.getDescripcion());
        } catch (KamaduinoException k) {
            LOGGER.error(k.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaSensorData, HttpStatus.OK);
    }

//    @RequestMapping(value = EndPoints.READ_DATA_SENSOR_HUMEDAD_CUSTOM, method = RequestMethod.GET)
//    @ApiOperation(value = StringsUtil.DATA_CTRL_VALUE_READ_DATA_SENSOR_HUMEDAD_CUSTOM, notes = StringsUtil.DATA_CTRL_NOTES_READ_DATA_SENSOR_HUMEDAD_CUSTOM)
//    public ResponseEntity<HttpStatus> readDataHumedadFromBBDDCustom() {
//            //TODO IMPLEMENTAR
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
