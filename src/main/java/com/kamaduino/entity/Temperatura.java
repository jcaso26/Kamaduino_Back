package com.kamaduino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "temperatura")
public class Temperatura {

    @Id
    @Column(name = "idhum", unique = true)
    private int id;

    @Column(name = "valuesensor1", nullable = false)
    private float temperaturaSuperior;

    @Column(name = "valuesensor2", nullable = false)
    private float temperaturaInferior;

    @Column(name="timinsert", nullable = false)
    private Date time;

    public Temperatura(){}

    public Temperatura(int id, float temperaturaSuperior, float temperaturaInferior, Date time) {
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


    @Override
    public String toString() {
        return this.id + "\t" + this.temperaturaSuperior + "\t" + this.temperaturaInferior + "\t" + this.time;
    }
}
