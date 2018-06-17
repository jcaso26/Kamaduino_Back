package com.kamaduino.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class SensorDataDTO {

    @ApiModelProperty(notes = "Valor leído")
    private Double valor;

    @ApiModelProperty(notes = "Timestamp de la lectura")
    private Date date;

    @ApiModelProperty(notes = "Identificador de la lectura")
    private Long id;

    @ApiModelProperty(notes = "Identificador del Sensor")
    private String idSensor;

    public SensorDataDTO(Double valor, Date date, String idSensor) {
        this.valor = valor;
        this.date = date;
        this.idSensor = idSensor;
    }

    public SensorDataDTO(Double valor, String idSensor) {
        this.valor = valor;
        this.idSensor = idSensor;
    }

    public SensorDataDTO(Long id, Double valor, Date date, String idSensor) {
        this.id = id;
        this.valor = valor;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }
}
