package com.zeotap.Weather_Monotoring.controller;

import com.zeotap.Weather_Monotoring.model.AverageTemperature;
import com.zeotap.Weather_Monotoring.model.WeatherAlert;
import com.zeotap.Weather_Monotoring.model.ThresholdSetting;
import com.zeotap.Weather_Monotoring.service.AggregationService;
import com.zeotap.Weather_Monotoring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @Autowired
    private AggregationService aggregationService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/average-temperature")
    public ResponseEntity<AverageTemperature> getAverageTemperature() {
        AverageTemperature averageTemp = aggregationService.getHourlyAverage();
        return ResponseEntity.ok(averageTemp);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Double>> getTemperatureHistory() {
        ThresholdSetting setting = null;
        List<Double> history = List.copyOf(weatherService.getTemperatureHistory(setting.getThreshold()));
        return ResponseEntity.ok(history);
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<String>> getTriggeredAlerts() {
        List<String> alerts = weatherService.getTriggeredAlerts();
        return ResponseEntity.ok(alerts);
    }

    // POST method to set temperature threshold
    @PostMapping("/threshold")
    public ResponseEntity<String> setTemperatureThreshold(@RequestBody ThresholdSetting setting) {
        weatherService.getTemperatureHistory(setting.getThreshold());
        return ResponseEntity.ok("Threshold set to " + setting.getThreshold() + "°C");
    }

    // POST method to add a weather alert
    @PostMapping("/alerts")
    public ResponseEntity<String> addWeatherAlert(@RequestBody WeatherAlert alert) {
        weatherService.addAlert(alert);
        return ResponseEntity.ok("Alert added: " + alert.getMessage());
    }

    // POST method to log a temperature reading
    @PostMapping("/temperature")
    public ResponseEntity<String> logTemperature(@RequestBody Double temperature) {
        weatherService.logTemperature(temperature);
        return ResponseEntity.ok("Temperature logged: " + temperature + "°C");
    }
}
