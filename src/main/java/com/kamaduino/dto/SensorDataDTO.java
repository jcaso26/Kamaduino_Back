package com.kamaduino.dto;

import io.swagger.annotations.ApiModelProperty;

public class SensorDataDTO {

    @ApiModelProperty(notes = "Valor leído")
    private Double valor;

    @ApiModelProperty(notes = "Timestamp de la lectura")
    private String time;

    @ApiModelProperty(notes = "Identificador de la lectura")
    private Long id;

    @ApiModelProperty(notes = "Identificador del Sensor")
    private String idSensor;

    public SensorDataDTO(Double valor, String time, String idSensor) {
        this.valor = valor;
        this.time = time;
        this.idSensor = idSensor;
    }

    public SensorDataDTO(Long id, Double valor, String time, String idSensor) {
        this.id = id;
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
}
