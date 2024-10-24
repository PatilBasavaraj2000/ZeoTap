package com.zeotap.Weather_Monotoring.service;

import com.zeotap.Weather_Monotoring.model.DailySummary;
import com.zeotap.Weather_Monotoring.model.WeatherAlert;
import com.zeotap.Weather_Monotoring.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final String apiKey = "5b6b926ae3fc84cada7fffbbd90e2155"; // Ensure API key is secure
    private final WeatherConfig weatherConfig;

    private Queue<Double> temperatureHistory = new LinkedList<>();
    private int alertCount = 0;

    @Autowired
    public WeatherService(RestTemplateBuilder restTemplateBuilder, WeatherConfig weatherConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.weatherConfig = weatherConfig;
    }

    public WeatherService(RestTemplate restTemplate, WeatherConfig weatherConfig) {
        this.restTemplate = restTemplate;
        this.weatherConfig = weatherConfig;
        return;
    }

    @Scheduled(fixedRate = 60000) // Fetch every minute
    public void fetchWeatherData() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=YourCity&appid=" + apiKey + "&units=metric";
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response != null && response.getMain() != null) {
            double currentTemperature = response.getMain().getTemp();
            trackTemperature(currentTemperature);
            checkForAlerts(currentTemperature);
        }
    }

    public void trackTemperature(double temperature) {
        temperatureHistory.add(temperature);
        if (temperatureHistory.size() > weatherConfig.getConsecutiveUpdates()) {
            temperatureHistory.poll(); // Remove oldest entry
        }
    }

    private void checkForAlerts(double currentTemperature) {
        if (currentTemperature > weatherConfig.getTemperatureThreshold()) {
            alertCount++;
            if (alertCount >= weatherConfig.getConsecutiveUpdates()) {
                triggerAlert(currentTemperature);
                alertCount = 0; // Reset after alerting
            }
        } else {
            alertCount = 0; // Reset if below threshold
        }
    }

    private void triggerAlert(double temperature) {
        System.out.println("Alert! Temperature exceeded threshold: " + temperature + "°C");
        // Additional logic for email notifications can be added here
    }

    public Queue<Double> getTemperatureHistory(String threshold) {
        return temperatureHistory;
    }

    public List<String> getTriggeredAlerts() {
        // Implement logic to return a list of triggered alerts
        return new ArrayList<>(); // Placeholder
    }

    public static double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double convertKelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    public DailySummary calculateDailySummary() {
        double sum = 0.0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        String dominantCondition = "Clear"; // Placeholder for actual condition logic

        if (temperatureHistory.isEmpty()) {
            return new DailySummary(0, 0, 0, dominantCondition); // Return defaults if no data
        }

        for (double temp : temperatureHistory) {
            sum += temp;
            if (temp > max) max = temp;
            if (temp < min) min = temp;
        }

        double averageTemp = sum / temperatureHistory.size();
        return new DailySummary(averageTemp, max, min, dominantCondition);
    }

    public void setThreshold(double v) {
    }

    public boolean isAlertTriggered() {
        return false;
    }

    public void addAlert(WeatherAlert alert) {
    }

    public void logTemperature(Double temperature) {
    }
}
