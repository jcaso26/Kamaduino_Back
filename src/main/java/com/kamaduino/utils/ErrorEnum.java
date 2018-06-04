package com.kamaduino.utils;

public enum ErrorEnum {
    /** ERRORES */

    OK(0, "KAMADUINO[0] - OK"),
    ERROR_LECTURA_FICHEROS_HISTORICO(1, "KAMADUINO-ERROR[1] - Error de Lectura de los Ficheros Históricos creados por el controlador"),
    ERROR_NO_DATA_EN_FICHEROS(2, "KAMADUINO-ERROR[2] - No hay datos en ficheros para almacenar"),
    ERROR_ID_SENSOR_NO_VALIDO(3, "KAMADUINO-ERROR[3] - El id indicado no coincide con ningún sensor"),
    ERROR_LECTURA_ESCRITURA_FICHEROS(4, "KAMADUINO-ERROR[4] - Error en la lectura/escritura de los ficheros");

    private final int value;

    private final String descripcion;


    ErrorEnum(int value, String descripcion) {
        this.value = value;
        this.descripcion = descripcion;
    }

    public int getValue() {
        return value;
    }

    public String getDescripcionError() {
        return descripcion;
    }
}
