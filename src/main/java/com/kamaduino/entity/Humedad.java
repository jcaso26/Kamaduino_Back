package com.kamaduino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "humedad")
public class Humedad implements Serializable{

    @Id
    @Column(name = "idhum", unique = true)
    private int id;

    @Column(name = "valuesensor1", nullable = false)
    private float humedadSuperior;

    @Column(name = "valuesensor2", nullable = false)
    private float humedadInferior;

    @Column(name="timinsert", nullable = false)
    private Date time;

    public Humedad(){
    }

    public Humedad(int id, float humedadSuperior, float humedadInferior, Date time) {
        this.id = id;
        this.humedadSuperior = humedadSuperior;
        this.humedadInferior = humedadInferior;
        this.time = time;
    }

    public Humedad(float humedadSuperior, float humedadInferior, Date time) {
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


    @Override
    public String toString() {
        return this.id + "\t" + this.humedadSuperior + "\t" + this.humedadInferior + "\t" + this.time;
    }

}
