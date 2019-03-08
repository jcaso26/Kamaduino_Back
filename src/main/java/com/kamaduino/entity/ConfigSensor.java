package com.kamaduino.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "configsensor")
public class ConfigSensor implements Serializable {

    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "valuemin", nullable = true)
    private Double valorMin;

    @Column(name = "valuemax", nullable = true)
    private Double valorMax;

    @Column(name = "horaon", nullable = true)
    private LocalTime timeOn;

    @Column(name = "horaoff", nullable = true)
    private LocalTime timeOff;

    @Column(name = "idsensor", nullable = false)
    private String idSensor;

    public ConfigSensor(Long id, Double valorMin, Double valorMax, LocalTime timeOn, LocalTime timeOff, String idSensor) {
        this.id = id;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.timeOn = timeOn;
        this.timeOff = timeOff;
        this.idSensor = idSensor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorMin() {
        return valorMin;
    }

    public void setValorMin(Double valorMin) {
        this.valorMin = valorMin;
    }

    public Double getValorMax() {
        return valorMax;
    }

    public void setValorMax(Double valorMax) {
        this.valorMax = valorMax;
    }

    public LocalTime getTimeOn() {
        return timeOn;
    }

    public void setTimeOn(LocalTime timeOn) {
        this.timeOn = timeOn;
    }

    public LocalTime getTimeOff() {
        return timeOff;
    }

    public void setTimeOff(LocalTime timeOff) {
        this.timeOff = timeOff;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    @Override
    public String toString() {
        return "ConfigSensor{" +
                "id=" + id +
                ", valorMin=" + valorMin +
                ", valorMax=" + valorMax +
                ", timeOn=" + timeOn +
                ", timeOff=" + timeOff +
                ", idSensor='" + idSensor + '\'' +
                '}';
    }
}