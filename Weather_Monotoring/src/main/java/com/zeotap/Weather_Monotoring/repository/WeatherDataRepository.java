package com.zeotap.Weather_Monotoring.repository;

import com.zeotap.Weather_Monotoring.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    // You can define custom query methods here if needed
}
