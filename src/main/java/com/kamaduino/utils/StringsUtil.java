package com.kamaduino.utils;

public interface StringsUtil {

    /** == CONTROLADORES == */

    String DATA_CTRL_VALUE_READ_ACTUAL_SENSOR_DATA = "Lee los valores actuales de los sensores";
    String DATA_CTRL_NOTES_READ_ACTUAL_SENSOR_DATA = "Lee los valores actuales de los sensores. Para no desincronizar la escritura del fichero, leemos la ultima linea del fichero";
    String DATA_CTRL_VALUE_READ_FILE_DATA_WRITE_BBDD = "Lectura/Escritura del histórico de datos";
    String DATA_CTRL_NOTES_READ_FILE_DATA_WRITE_BBDD = "Lee los ficheros que contiene los valores de los sensores, generados por el controlador Arduino, los guarda en base de datos y elimina dichos ficheros";
    String LOGIN_CTRL_VALUE_LOGIN = "Login de la Aplicación";
    String LOGIN_CTRL_NOTES_LOGIN = "Comprueba los credenciales de los usurios para acceder a la aplicación";
    String DATA_CTRL_VALUE_READ_DATA_SENSOR = "Obtención de datos de los sensores";
    String DATA_CTRL_NOTES_READ_DATA_SENSOR = "Obtiene de la base de datos los valores de los sensores pasados por parametros";
    String ARDUINO_CTRL_VALUE_WRITE_CONFIG_DATA_ARDUINO = "Cambia los valores de la configuración de sensores";
    String ARDUINO_CTRL_NOTES_WRITE_CONFIG_DATA_ARDUINO = "Pasa valores de configuración a arduino y los guarda en base de datos";
    String ARDUINO_CTRL_VALUE_UPDATE_CONFIG_DATA_ARDUINO_BY_ID = "Cambia los valores de la configuración de un sensor";
    String ARDUINO_CTRL_NOTES_UPDATE_CONFIG_DATA_ARDUINO_BY_ID = "Pasa valores de configuración de un sensor y lo guarda en base de datos";
    String ARDUINO_CTRL_VALUE_READ_CONFIG_DATA_ARDUINO = "Obtiene los valores de configuración de los sensores";
    String ARDUINO_CTRL_NOTES_READ_CONFIG_DATA_ARDUINO = "Obtiene todos los valores de configuración de los sensores de Arduino";

    /** == FICHEROS == */
    String TOKEN = "#";
    String COMMENT_FILE = "--";
    String TXT_EXTENSION = ".txt";
    String PUNTO = ".";
    String ESPACIO = " ";

    /** */
    String TIME_PATTERN = "HH:mm";
    String DATE_PATTERN = "dd-MM-yyyy";
    String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm";

    String FICHEROS_ALMACENADOS = "Almacenados {0} registros en BBDD";
    String FICHERO_CREADO = "Creado nuevo fichero {0}";
    String FICHERO_ELIMINADO = "Fichero {0} eliminado";

}
