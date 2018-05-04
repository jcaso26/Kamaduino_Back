package com.kamaduino.dto;

import java.util.Date;

public class TemperaturaDTO {

    private float temperaturaSuperior;

    private float temperaturaInferior;

    private Date time;

    private int id;

    public TemperaturaDTO(int id, float temperaturaSuperior, float temperaturaInferior, Date time) {
        this.id = id;
        this.temperaturaSuperior = temperaturaSuperior;
        this.temperaturaInferior = temperaturaInferior;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTemperaturaSuperior() {
        return temperaturaSuperior;
    }

    public void setTemperaturaSuperior(float temperaturaSuperior) {
        this.temperaturaSuperior = temperaturaSuperior;
    }

    public float getTemperaturaInferior() {
        return temperaturaInferior;
    }

    public void setTemperaturaInferior(float temperaturaInferior) {
        this.temperaturaInferior = temperaturaInferior;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
