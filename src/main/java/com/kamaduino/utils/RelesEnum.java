package com.kamaduino.utils;

import org.springframework.beans.factory.annotation.Value;

public enum RelesEnum {
    /** IDENTIFICADORES DE LOS RELÉS */
    RELE_LUZ_UVB(1, "RELE_LUZ_UVB"),
    RELE_CALOR(2, "RELE_CALOR");

    private final int value;

    private final String descripcion;

    @Value("${arduino.numero.reles}")
    public static int NUMERO_RELES;

    RelesEnum(int value, String descripcion) {
        this.value = value;
        this.descripcion = descripcion;
    }

    public int getValue() {
        return value;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static String getDescripcionFromValue(int value){
        String descripcion;
        switch (value){
            case 1: descripcion = RELE_LUZ_UVB.descripcion;
                break;
            case 2: descripcion = RELE_CALOR.descripcion;
                break;
            default: descripcion = ErrorEnum.ERROR_ID_RELE_NO_VALIDO.getDescripcionError();
                break;
        }
        return descripcion;
    }

}
