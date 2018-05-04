package com.kamaduino.converter;

import com.kamaduino.dto.TemperaturaDTO;
import com.kamaduino.entity.Temperatura;

public class TemperaturaConverter {

    public static TemperaturaDTO entityToDTO(Temperatura temperatura){
        TemperaturaDTO temperaturaDTO = new TemperaturaDTO(temperatura.getId(), temperatura.getTemperaturaSuperior(), temperatura.getTemperaturaInferior(), temperatura.getTime());
        return temperaturaDTO;
    }

//    public static TemperaturaDTO entityToDTO(Temperatura temperatura){
//        //TODO
//        TemperaturaDTO temperaturaDTO = new TemperaturaDTO();
//
//        return temperaturaDTO;
//    }
//
//    public static Temperatura dtoToEntity(TemperaturaDTO temperaturaDTO){
//        //TODO
//        Temperatura temperatura = new Temperatura();
//
//        return temperatura;
//    }

}
