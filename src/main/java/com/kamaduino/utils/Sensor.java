package com.kamaduino.utils;

import org.springframework.beans.factory.annotation.Value;

public enum Sensor {
    /** IDENTIFICADORES DE LOS SENSORES */
    SENSOR_HUMEDAD_ARRIBA(1, "Sensor Humedad Superior"),
    SENSOR_HUMEDAD_ABAJO(2, "Sensor Humedad Inferior"),
    SENSOR_TEMPERATURA_ARRIBA(3, "Sensor Temperatura Superior"),
    SENSOR_TEMPERATURA_ABAJO(4, "Sensor Temperatura Inferior"),
    SENSOR_NIVEL_AGUA(5, "Sensor Nivel de Agua");

    private final int value;

    private final String descripcion;

    @Value("${arduino.numero.sensores}")
    public static int NUMERO_SENSORES;

    Sensor(int value, String descripcion) {
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
