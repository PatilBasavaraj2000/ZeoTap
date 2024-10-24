package com.zeotap.Weather_Monotoring.model;

public class AverageTemperature {
    private double averageTemp;
    private String period; // e.g., "last hour"

    public AverageTemperature(double averageTemp, String period) {
        this.averageTemp = averageTemp;
        this.period = period;
    }

    public double getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(double averageTemp) {
        this.averageTemp = averageTemp;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
