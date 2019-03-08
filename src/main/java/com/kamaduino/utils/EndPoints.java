package com.kamaduino.utils;

public interface EndPoints {
//    static final String GET_USER_BY_ID = "/getUser/{userId}";
//    static final String GET_ALL_USERS = "/getAllUsers";
//    static final String SAVE_USER = "/saveUser";

    /** ENDPOINTS */
    String LOGIN = "/api/login";
    String READ_ACTUAL_SENSOR_DATA = "/api/readDataSensor";
    String WRITE_CONFIG_DATA_ARDUINO = "/api/ardwrite";
//    String UPDATE_CONFIG_DATA_ARDUINO_BY_ID = "/api/ardwrite/{sensorId}";
    String UPDATE_CONFIG_DATA_ARDUINO_BY_ID = "/api/ardwriteUpdate";
    String READ_CONFIG_DATA_ARDUINO = "/api/ardread";
    String READ_FILE_DATA_WRITE_BBDD = "/api/historical";
    String READ_DATA_SENSOR = "/api/readData/{sensorId}";

}