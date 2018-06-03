package com.kamaduino.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sensordata")
public class SensorData implements Serializable{

    @Id
    @Column(name = "idlectura", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = false)
    private Double valor;

    @Column(name="timinsert", nullable = false)
    private String time;

    @Column(name="idsensor", nullable = false)
    private String idSensor;

    public SensorData(){
    }

    public SensorData(Long id, Double valor, String time, String idSensor) {
        this.id = id;
        this.valor = valor;
        this.time = time;
        this.idSensor = idSensor;
    }

    public SensorData(Double valor, String time, String idSensor) {
        this.valor = valor;
        this.time = time;
        this.idSensor = idSensor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.valor+ "\t" + this.time + "\t" + this.idSensor;
    }

}
