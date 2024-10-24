package com.zeotap.Weather_Monotoring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

    private Main main;

    @JsonProperty("dt")
    private long timestamp;

    // Getters and setters
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class Main {
        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;

        public Main(double v) {
        }

        // Getters and setters
        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }
    }
}

