package com.kamaduino.converter;

import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.entity.SensorData;
import com.kamaduino.utils.SensorEnum;

import java.util.ArrayList;
import java.util.List;

public class SensorDataConverter {

    /**
     *
     * @param sensor
     * @return
     */
    public static SensorDataDTO entityToDTO(SensorData sensor){
        SensorDataDTO sensorDataDTO = new SensorDataDTO(sensor.getId(), sensor.getValor(), sensor.getTime(), sensor.getIdSensor());
        return sensorDataDTO;
    }

    /**
     *
     * @param sensorDataDTO
     * @return
     */
    public static SensorData dtoToEntity(SensorDataDTO sensorDataDTO){
        SensorData sensorData = new SensorData(sensorDataDTO.getValor(), sensorDataDTO.getTime(), sensorDataDTO.getIdSensor());
        return sensorData;
    }

    /**
     *
     * @param cadenaDatos
     * @return
     */
    public static List<SensorDataDTO> textToDTO(String cadenaDatos){
        List<SensorDataDTO> listaDTO = new ArrayList<>();
        SensorDataDTO sensorDTO;
        String[] cadenaDatosTokens = cadenaDatos.split("#");
        String hora = cadenaDatosTokens[0];
        for(int i=1; i<cadenaDatosTokens.length;i++){
            sensorDTO = new SensorDataDTO(Double.parseDouble(cadenaDatosTokens[i]), hora, SensorEnum.getDescripcionFromValue(i));
            listaDTO.add(sensorDTO);
        }

        return listaDTO;
    }
}