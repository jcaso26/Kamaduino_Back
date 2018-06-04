package com.kamaduino.exceptions;

import com.kamaduino.utils.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KamaduinoException extends Exception {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final String message;

    public KamaduinoException(String message) {
        this.message = message;
        LOGGER.error(message);
    }

    public KamaduinoException(ErrorEnum error){
        this.message = error.getDescripcionError();
        LOGGER.error(error.getDescripcionError());
    }

    public KamaduinoException(ErrorEnum error, String message){
        this.message = error.getDescripcionError();
        LOGGER.error(error.getDescripcionError(), message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
