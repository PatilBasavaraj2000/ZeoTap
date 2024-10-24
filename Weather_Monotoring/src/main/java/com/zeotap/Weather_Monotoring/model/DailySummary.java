package com.zeotap.Weather_Monotoring.model;

public class DailySummary {
    private double averageTemperature;
    private double maxTemperature;
    private double minTemperature;
    private String dominantCondition; // e.g., "Clear", "Rain"

    public DailySummary(double averageTemperature, double maxTemperature, double minTemperature, String dominantCondition) {
        this.averageTemperature = averageTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.dominantCondition = dominantCondition;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getDominantCondition() {
        return dominantCondition;
    }

    public void setDominantCondition(String dominantCondition) {
        this.dominantCondition = dominantCondition;
    }
}
