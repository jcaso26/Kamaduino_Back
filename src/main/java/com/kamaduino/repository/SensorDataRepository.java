package com.kamaduino.repository;

import com.kamaduino.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    @Query (value = "SELECT * FROM SENSORDATA S WHERE S.IDSENSOR = :sensorId", nativeQuery = true)
    List<SensorData> getSensorDataBySensorId(@Param("sensorId") String sensorId);
}

