package com.kamaduino.utils;

public interface StringsUtil {

    /** == CONTROLADORES == */

    String DATA_CTRL_VALUE_READ_ACTUAL_SENSOR_DATA = "Lee los valores actuales de los sensores";
    String DATA_CTRL_NOTES_READ_ACTUAL_SENSOR_DATA = "Lee los valores actuales de los sensores. Para no desincronizar la escritura del fichero, leemos la ultima linea del fichero";
    String DATA_CTRL_VALUE_READ_FILE_DATA_WRITE_BBDD = "Lectura/Escritura del histórico de datos";
    String DATA_CTRL_NOTES_READ_FILE_DATA_WRITE_BBDD = "Lee los ficheros que contiene los valores de los sensores, generados por el controlador Arduino, los guarda en base de datos y elimina dichos ficheros";
    String LOGIN_CTRL_VALUE_LOGIN = "Login de la Aplicación";
    String LOGIN_CTRL_NOTES_LOGIN = "Comprueba los credenciales de los usurios para acceder a la aplicación";
//    String DATA_CTRL_VALUE_READ_DATA_SENSOR_HUMEDAD_CUSTOM = "Lectura de los datos de Humedad de la zona pasada por parámetro";
//    String DATA_CTRL_NOTES_READ_DATA_SENSOR_HUMEDAD_CUSTOM = "Obtiene de la base de datos los valores de humedad de la zona indicada en el parámetro";
    String DATA_CTRL_VALUE_READ_DATA_SENSOR = "Obtención de datos de los sensores";
    String DATA_CTRL_NOTES_READ_DATA_SENSOR = "Obtiene de la base de datos los valores de los sensores pasados por parametros";

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
