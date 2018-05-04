package com.kamaduino.dto;

import java.util.Date;

public class HumedadDTO {

    private float humedadSuperior;

    private float humedadInferior;

    private Date time;

    private int id;

    public HumedadDTO(int id, float humedadSuperior, float humedadInferior, Date time) {
        this.id = id;
        this.humedadSuperior = humedadSuperior;
        this.humedadInferior = humedadInferior;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHumedadSuperior() {
        return humedadSuperior;
    }

    public void setHumedadSuperior(float humedadSuperior) {
        this.humedadSuperior = humedadSuperior;
    }

    public float getHumedadInferior() {
        return humedadInferior;
    }

    public void setHumedadInferior(float humedadInferior) {
        this.humedadInferior = humedadInferior;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
