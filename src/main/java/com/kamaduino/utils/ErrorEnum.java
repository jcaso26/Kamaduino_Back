package com.kamaduino.utils;

public enum ErrorEnum {
    /** ERRORES */

    ERROR_LECTURA_FICHEROS_HISTORICO(1, "KAMADUINO-ERROR[1] - Error de Lectura de los Ficheros Históricos creados por el controlador"),
    SENSOR_HUMEDAD_ABAJO(2, "HUMEDAD_INFERIOR"),
    SENSOR_TEMPERATURA_ARRIBA(3, "TEMPERATURA_SUPERIOR"),
    SENSOR_TEMPERATURA_ABAJO(4, "TEMPERATURA_INFERIOR"),
    SENSOR_NIVEL_AGUA(5, "NIVEL_AGUA");

    private final int value;

    private final String descripcion;


    ErrorEnum(int value, String descripcion) {
        this.value = value;
        this.descripcion = descripcion;
    }

    public int getValue() {
        return value;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
