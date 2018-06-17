package com.kamaduino.converter;

import com.kamaduino.dto.SensorDataDTO;
import com.kamaduino.entity.SensorData;
import com.kamaduino.exceptions.KamaduinoException;
import com.kamaduino.utils.ErrorEnum;
import com.kamaduino.utils.SensorEnum;
import com.kamaduino.utils.StringsUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SensorDataConverter {

    /**
     * Convierte una entidad Sensor a un DTO Sensor
     * @param sensor entidad Sensor para convertir
     * @return DTO Sensor convertida
     */
    public static SensorDataDTO entityToDTO(SensorData sensor) throws KamaduinoException{
        SimpleDateFormat sf = new SimpleDateFormat(StringsUtil.DATE_TIME_PATTERN);
        Date date;
        String sDate;

        try {
            sDate = sf.format(sensor.getDate());
            date = sf.parse(sDate);
        } catch (ParseException e) {
            throw new KamaduinoException(ErrorEnum.ERROR_PARSE_FECHAS, e.getMessage());
        }

        SensorDataDTO sensorDataDTO = new SensorDataDTO(sensor.getId(), sensor.getValor(), date, sensor.getIdSensor());
        return sensorDataDTO;
    }

    /**
     * Convierte un DTO Sensor a una  entidad Sensor
     * @param sensorDataDTO DTO Sensor para convertir
     * @return entidad Sensor convertida
     */
    public static SensorData dtoToEntity(SensorDataDTO sensorDataDTO){
        SensorData sensorData = new SensorData(sensorDataDTO.getValor(), sensorDataDTO.getDate(), sensorDataDTO.getIdSensor());
        return sensorData;
    }

    /**
     * Transforma una cadena de texto a una lista de DTO Sensor
     * @param cadenaDatos cadena de texto con los datos
     * @return Lista de DTO Sensor
     */
    public static List<SensorDataDTO> textToDTO(String cadenaDatos){
        List<SensorDataDTO> listaDTO = new ArrayList<>();
        SensorDataDTO sensorDTO;
        String[] cadenaDatosTokens = cadenaDatos.split(StringsUtil.TOKEN);
        for(int i=1; i<cadenaDatosTokens.length;i++){
            sensorDTO = new SensorDataDTO(Double.parseDouble(cadenaDatosTokens[i]), SensorEnum.getDescripcionFromValue(i));
            listaDTO.add(sensorDTO);
        }

        return listaDTO;
    }

    /**
     * Transforma una lista de entidades Sensor a una lista DTO Sensor
     * @param listEntity lista de entidades Sensor
     * @return Lista de DTO Sensor
     */
    public static List<SensorDataDTO> listEntityToDTO(List<SensorData> listEntity) throws KamaduinoException {
        List<SensorDataDTO> listaSensorDataDTO = new ArrayList<>();
        for(SensorData sensorData : listEntity){
            listaSensorDataDTO.add(entityToDTO(sensorData));
        }
        return listaSensorDataDTO;
    }
}