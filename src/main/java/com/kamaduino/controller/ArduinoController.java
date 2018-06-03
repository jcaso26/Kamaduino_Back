package com.kamaduino.controller;

import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.service.ArduinoService;
import com.kamaduino.utils.EndPoints;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArduinoController {

    @Autowired
    ArduinoService arduinoService;

    @RequestMapping(value = EndPoints.READ_ACTUAL_SENSOR_DATA, method = RequestMethod.GET)
    @ApiOperation(value = "Lee los valores actuales de los sensores", notes = "Lee los valores actuales de los sensores. " +
            "Para no desincronizar la escritura del fichero, leemos la ultima linea del fichero")
    public ResponseEntity<List<SensorDataDTO>> readActualSensorData(){
        List<SensorDataDTO> listaSensorDAta;
        try {
            listaSensorDAta = arduinoService.readActualSensorData();
        } catch (KamaduinoException e) {
//            e.printStackTrace();
//            //TODO LOGGER MENSAJE y NUEVOS MENSAJES
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    @ApiOperation(value = "Lectura/Escritura del histórico de datos",
            notes = "Lee los ficheros que contiene los valores de los sensores, generados por el controlador Arduino, los guarda en base de datos y elimina dichos ficheros")
    public ResponseEntity<HttpStatus>  readDataFromFileToBBDD(){
        try {
             arduinoService.readWriteDataBBDD();
        } catch (KamaduinoException k) {
            k.getMessage();
            //TODO LOGGER MENSAJE y NUEVOS MENSAJES
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
