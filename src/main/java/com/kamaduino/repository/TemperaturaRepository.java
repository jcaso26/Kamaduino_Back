package com.kamaduino.repository;

import com.kamaduino.entity.Temperatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer>{
}
