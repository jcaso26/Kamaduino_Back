package com.kamaduino.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sensordata")
public class SensorData implements Serializable{

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = false)
    private Double valor;

    @Column(name="fechahora", nullable =false)
    private Date date;

    @Column(name="idsensor", nullable = false)
    private String idSensor;

    public SensorData(){
    }

    public SensorData(Long id, Double valor, Date date, String idSensor) {
        this.id = id;
        this.valor = valor;
        this.date = date;
        this.idSensor = idSensor;
    }

    public SensorData(Double valor, Date date, String idSensor) {
        this.valor = valor;
        this.idSensor = idSensor;
        this.date = date;
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

    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.valor+ "\t" + this.date + "\t" + this.idSensor;
    }

}
