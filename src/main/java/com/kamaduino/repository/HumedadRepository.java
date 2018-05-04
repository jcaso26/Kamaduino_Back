package com.kamaduino.repository;

import com.kamaduino.entity.Humedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumedadRepository extends JpaRepository<Humedad, Integer> {
}

