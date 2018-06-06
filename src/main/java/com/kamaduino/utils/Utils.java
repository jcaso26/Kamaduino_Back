package com.kamaduino.utils;

import java.text.MessageFormat;

public class Utils {

    /**
     * Devuelve un mensaje parametrizado
     * @param message Texto del mensaje
     * @param objArray Parametros para completar el mensaje
     * @return String con el mensaje compuesto
     */
    public static String getMessage(String message, Object[] objArray){
        MessageFormat mf = new MessageFormat(message);
        return mf.format(objArray);
    }
}
