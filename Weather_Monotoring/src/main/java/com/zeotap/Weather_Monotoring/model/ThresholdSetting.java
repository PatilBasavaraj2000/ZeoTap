package com.zeotap.Weather_Monotoring.model;

public class ThresholdSetting {
    private double temperatureThreshold; // Threshold for temperature
    private double humidityThreshold;    // Threshold for humidity
    private double windSpeedThreshold;   // Threshold for wind speed
    private String alertMessage;         // Custom alert message

    // Constructor
    public ThresholdSetting(double temperatureThreshold, double humidityThreshold, double windSpeedThreshold, String alertMessage) {
        this.temperatureThreshold = temperatureThreshold;
        this.humidityThreshold = humidityThreshold;
        this.windSpeedThreshold = windSpeedThreshold;
        this.alertMessage = alertMessage;
    }

    // Getters
    public double getTemperatureThreshold() {
        return temperatureThreshold;
    }

    public double getHumidityThreshold() {
        return humidityThreshold;
    }

    public double getWindSpeedThreshold() {
        return windSpeedThreshold;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    // Method to check if current conditions exceed thresholds
    public boolean isThresholdExceeded(double currentTemperature, double currentHumidity, double currentWindSpeed) {
        return currentTemperature > temperatureThreshold ||
                currentHumidity > humidityThreshold ||
                currentWindSpeed > windSpeedThreshold;
    }

    @Override
    public String toString() {
        return "ThresholdSetting{" +
                "temperatureThreshold=" + temperatureThreshold +
                ", humidityThreshold=" + humidityThreshold +
                ", windSpeedThreshold=" + windSpeedThreshold +
                ", alertMessage='" + alertMessage + '\'' +
                '}';
    }

    public String getThreshold() {
        return "";
    }
}
