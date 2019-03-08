package com.kamaduino.dto;

import io.swagger.annotations.ApiModelProperty;

public class ConfigSensorDTO {

    @ApiModelProperty(notes = "Identificador único")
    private Long id;

    @ApiModelProperty(notes = "Valor mínimo del sensor")
    private Double valorMin;

    @ApiModelProperty(notes = "Valor máximo del sensor")
    private Double valorMax;

//    @ApiModelProperty(notes = "Hora activación del sensor")
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    private LocalTime timeOn;

//    @ApiModelProperty(notes = "Hora desactivación del sensor")
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    private LocalTime timeOff;

    @ApiModelProperty(notes = "Nombre del sensor")
    private String idSensor;



//    public ConfigSensorDTO(Long id, Double valorMin, Double valorMax, LocalTime timeOn, LocalTime timeOff, String idSensor) {
//        this.id = id;
//        this.valorMin = valorMin;
//        this.valorMax = valorMax;
//        this.timeOn = timeOn;
//        this.timeOff = timeOff;
//        this.idSensor = idSensor;
//    }

    public ConfigSensorDTO(Long id, Double valorMin, Double valorMax, String idSensor) {
        this.id = id;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
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

//    public LocalTime getTimeOn() {
//        return timeOn;
//    }
//
//    public void setTimeOn(LocalTime timeOn) {
//        this.timeOn = timeOn;
//    }
//
//    public LocalTime getTimeOff() {
//        return timeOff;
//    }
//
//    public void setTimeOff(LocalTime timeOff) {
//        this.timeOff = timeOff;
//    }

    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    @Override
    public String toString() {
        return "ConfigSensorDTO{" +
                "id=" + id +
                ", valorMin=" + valorMin +
                ", valorMax=" + valorMax +
//                ", timeOn=" + timeOn +
//                ", timeOff=" + timeOff +
                ", idSensor='" + idSensor + '\'' +
                '}';
    }
}
