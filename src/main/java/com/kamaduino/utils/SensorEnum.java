package com.kamaduino.utils;

import org.springframework.beans.factory.annotation.Value;

public enum SensorEnum {
    /** IDENTIFICADORES DE LOS SENSORES */
    SENSOR_HUMEDAD_ARRIBA(1, "HUMEDAD_SUPERIOR"),
    SENSOR_TEMPERATURA_ARRIBA(2, "TEMPERATURA_SUPERIOR"),
    SENSOR_HUMEDAD_ABAJO(3, "HUMEDAD_INFERIOR"),
    SENSOR_TEMPERATURA_ABAJO(4, "TEMPERATURA_INFERIOR"),
    SENSOR_NIVEL_AGUA(5, "NIVEL_AGUA");

    private final int value;

    private final String descripcion;

    @Value("${arduino.numero.sensores}")
    public static int NUMERO_SENSORES;

    SensorEnum(int value, String descripcion) {
        this.value = value;
        this.descripcion = descripcion;
    }

    public int getValue() {
        return value;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static String getDescripcionFromValue(int value){
        String descripcion;
        switch (value){
            case 1: descripcion = SENSOR_HUMEDAD_ARRIBA.descripcion;
                break;
            case 2: descripcion = SENSOR_TEMPERATURA_ARRIBA.descripcion;
                break;
            case 3: descripcion = SENSOR_HUMEDAD_ABAJO.descripcion;
                break;
            case 4: descripcion = SENSOR_TEMPERATURA_ABAJO.descripcion;
                break;
            case 5: descripcion = SENSOR_NIVEL_AGUA.descripcion;
                break;
            default: descripcion = ErrorEnum.ERROR_ID_SENSOR_NO_VALIDO.getDescripcionError();
                break;
        }
        return descripcion;
    }

}
