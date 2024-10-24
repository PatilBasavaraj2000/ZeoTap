package com.zeotap.Weather_Monotoring.model;

import com.zeotap.Weather_Monotoring.model.ThresholdSetting;

public class WeatherMonitoringApp {
    public static void main(String[] args) {
        // Create a ThresholdSetting instance
        ThresholdSetting thresholdSetting = new ThresholdSetting(
                30.0, // Temperature threshold in °C
                80.0, // Humidity threshold in %
                50.0, // Wind speed threshold in km/h
                "Alert: Threshold exceeded!"
        );

        // Current weather conditions
        double currentTemperature = 32.0;
        double currentHumidity = 75.0;
        double currentWindSpeed = 60.0;

        // Check if thresholds are exceeded
        if (thresholdSetting.isThresholdExceeded(currentTemperature, currentHumidity, currentWindSpeed)) {
            System.out.println(thresholdSetting.getAlertMessage());
        } else {
            System.out.println("All conditions are within safe limits.");
        }
    }
}
