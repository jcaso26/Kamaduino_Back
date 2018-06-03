package com.kamaduino.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

//    @Autowired
//    DataService dataService;
////    ArduinoService arduinoService;
//
//
//    @RequestMapping(value = EndPoints.READ_FILE_DATA_WRITE_BBDD, method = RequestMethod.GET)
//    @ApiOperation(value = "Lectura/Escritura del histórico de datos",
//            notes = "Lee los ficheros que contiene los valores de los sensores, generados por el controlador Arduino, los guarda en base de datos y elimina dichos ficheros")
//    public ResponseEntity<HttpStatus> readDataFromFileToBBDD() {
//        try {
//            dataService.readWriteDataBBDD();
//        } catch (KamaduinoException k) {
//            k.getMessage();
//            //TODO LOGGER MENSAJE y NUEVOS MENSAJES
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @RequestMapping(value = EndPoints.READ_DATA_SENSOR_HUMEDAD, method = RequestMethod.GET)
//    @ApiOperation(value = "Lectura del histórico de datos de Humedad",
//            notes = "Obtiene de la base de datos el histórico de humedad")
//    public ResponseEntity<HttpStatus> readDataHumedadFromBBDD() {
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
