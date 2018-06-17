package com.kamaduino.utils;

public interface EndPoints {
//    static final String GET_USER_BY_ID = "/getUser/{userId}";
//    static final String GET_ALL_USERS = "/getAllUsers";
//    static final String SAVE_USER = "/saveUser";

    /** ENDPOINTS */
    String LOGIN = "/api/login";
    String READ_ACTUAL_SENSOR_DATA = "/api/readDataSensor";
    String WRITE_DATA_ARDUINO = "/api/ardwrite";
    String READ_DATA_ARDUINO = "/api/ardread";
    String READ_FILE_DATA_WRITE_BBDD = "/api/historical";
    String READ_DATA_SENSOR = "/api/readData/{sensorId}";

}