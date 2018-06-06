package com.kamaduino.controller;

import com.kamaduino.dto.SensorDataDTO;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArduinoController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArduinoService arduinoService;

    @RequestMapping(value = EndPoints.READ_ACTUAL_SENSOR_DATA, method = RequestMethod.GET)
    @ApiOperation(value = StringsUtil.ARDUINO_CTRL_VALUE_READ_ACTUAL_SENSOR_DATA, notes = StringsUtil.ARDUINO_CTRL_NOTES_READ_ACTUAL_SENSOR_DATA)
    public ResponseEntity<List<SensorDataDTO>> readActualSensorData(){
        List<SensorDataDTO> listaSensorDAta;
        try {
            listaSensorDAta = arduinoService.readActualSensorData();
        } catch (KamaduinoException k) {
            LOGGER.error(k.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaSensorDAta, HttpStatus.OK);
    }

    @RequestMapping(value = EndPoints.WRITE_DATA_ARDUINO, method = RequestMethod.POST)
    @ApiOperation(value = "Pasa valores a arduino", notes = "Pasa valores de configuración a arduino. Ejemplo: Temperatura mínima, máxima, horarios, etc...")
    public ResponseEntity<HttpStatus> writeDataToArduino(){
        //TODO IMPLEMENTAR
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
    * LOS METODOS DE ABAJO VAN AL DATACONTROLLER
    * */
    @RequestMapping(value = EndPoints.READ_FILE_DATA_WRITE_BBDD, method = RequestMethod.GET)
    @ApiOperation(value = StringsUtil.ARDUINO_CTRL_VALUE_READ_FILE_DATA_WRITE_BBDD, notes = StringsUtil.ARDUINO_CTRL_NOTES_READ_FILE_DATA_WRITE_BBDD)
    public ResponseEntity<HttpStatus>  readDataFromFileToBBDD(){
        try {
             arduinoService.readWriteDataBBDD();
        } catch (KamaduinoException k) {
            LOGGER.error(k.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = EndPoints.READ_DATA_SENSOR_HUMEDAD, method = RequestMethod.GET)
//    @ApiOperation(value = "Lectura del histórico de datos de Humedad",
//            notes = "Obtiene de la base de datos el histórico de humedad")
//    public ResponseEntity<HttpStatus>  readDataHumedadFromBBDD(){
////        try {
////            arduinoService.readWriteDataBBDD();
////        } catch (KamaduinoException k) {
////            k.getMessage();
////            //TODO LOGGER MENSAJE y NUEVOS MENSAJES
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }



}
