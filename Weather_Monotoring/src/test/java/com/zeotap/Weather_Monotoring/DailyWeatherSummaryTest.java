package com.zeotap.Weather_Monotoring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import com.zeotap.Weather_Monotoring.model.DailySummary;
import com.zeotap.Weather_Monotoring.service.WeatherService;
import com.zeotap.Weather_Monotoring.service.WeatherConfig; // Ensure you import the WeatherConfig

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class DailyWeatherSummaryTest {

    private WeatherService weatherService;
    private WeatherConfig weatherConfig;
    private RestTemplateBuilder restTemplateBuilder;

    @BeforeEach
    public void setUp() {
        // Mock the dependencies
        restTemplateBuilder = mock(RestTemplateBuilder.class);
        weatherConfig = mock(WeatherConfig.class);

        // Create an instance of WeatherService with mocked dependencies
        weatherService = new WeatherService(restTemplateBuilder, weatherConfig);
    }

    @Test
    void testDailySummaryCalculation() {
        // Track some temperatures
        weatherService.trackTemperature(25.0);
        weatherService.trackTemperature(30.0);
        weatherService.trackTemperature(20.0);
        weatherService.trackTemperature(15.0);

        // Calculate the daily summary
        DailySummary summary = weatherService.calculateDailySummary();

        // Assert the expected values
        assertEquals(22.5, summary.getAverageTemperature(), 0.01);
        assertEquals(30.0, summary.getMaxTemperature(), 0.01);
        assertEquals(15.0, summary.getMinTemperature(), 0.01);
    }
}
