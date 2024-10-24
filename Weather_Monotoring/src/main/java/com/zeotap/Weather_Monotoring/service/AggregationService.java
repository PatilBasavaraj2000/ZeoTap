package com.zeotap.Weather_Monotoring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalDouble;

import com.zeotap.Weather_Monotoring.model.AverageTemperature;
import com.zeotap.Weather_Monotoring.model.WeatherData;
import com.zeotap.Weather_Monotoring.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AggregationService {
    @Autowired
    private WeatherDataRepository repository;

    public AverageTemperature getHourlyAverage() {
        // Fetch all WeatherData from the repository
        List<WeatherData> weatherDataList = repository.findAll();

        // Calculate the average temperature over the last hour
        OptionalDouble averageTemp = weatherDataList.stream()
                .filter(data -> data.getTimestamp().isAfter(LocalDateTime.now().minusHours(1)))
                .mapToDouble(WeatherData::getTemp) // Correctly reference the method
                .average();

        double averageTemperature = averageTemp.orElse(0.0); // Default to 0.0 if no data

        return new AverageTemperature(averageTemperature, "last hour");
    }
}
