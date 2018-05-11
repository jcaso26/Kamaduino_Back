package com.kamaduino.exceptions;

public class KamaduinoException extends Exception {

    private final String message;

    public KamaduinoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
