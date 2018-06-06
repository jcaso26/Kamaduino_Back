package com.kamaduino.utils;

public interface StringsUtil {

    /** CONTROLADORES */
    String ARDUINO_CTRL_VALUE_READ_ACTUAL_SENSOR_DATA = "Lee los valores actuales de los sensores";
    String ARDUINO_CTRL_NOTES_READ_ACTUAL_SENSOR_DATA = "Lee los valores actuales de los sensores. Para no desincronizar la escritura del fichero, leemos la ultima linea del fichero";
    String ARDUINO_CTRL_VALUE_READ_FILE_DATA_WRITE_BBDD = "Lectura/Escritura del histórico de datos";
    String ARDUINO_CTRL_NOTES_READ_FILE_DATA_WRITE_BBDD = "Lee los ficheros que contiene los valores de los sensores, generados por el controlador Arduino, los guarda en base de datos y elimina dichos ficheros";
    String LOGIN_CTRL_VALUE_LOGIN = "Login de la Aplicación";
    String LOGIN_CTRL_NOTES_LOGIN = "Comprueba los credenciales de los usurios para acceder a la aplicación";

    /** FICHEROS */
    String TOKEN = "#";
    String COMMENT_FILE = "--";
    String TXT_EXTENSION = ".txt";
    String PUNTO = ".";
    String ESPACIO = " ";

    /** */
    String TIME_PATTERN = "HH:mm";
    String DATE_PATTERN = "dd-MM-yyyy";

    String FICHEROS_ALMACENADOS = "Almacenados {0} registros en BBDD";
    String FICHERO_CREADO = "Creado nuevo fichero '{0}'";
    String FICHERO_ELIMINADO = "Fichero '{0}' eliminado";

}
