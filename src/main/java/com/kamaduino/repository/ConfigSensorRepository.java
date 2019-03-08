package com.kamaduino.repository;

import com.kamaduino.entity.ConfigSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConfigSensorRepository extends JpaRepository<ConfigSensor, Long> {

    @Query(value = "SELECT * FROM CONFIGSENSOR C WHERE C.IDSENSOR = :idSensor", nativeQuery = true)
    boolean existeConfigSensorById(String idSensor);

//    void insert(ConfigSensorDTO configSensorDTO);

//    void update(ConfigSensorDTO configSensorDTO);

}
