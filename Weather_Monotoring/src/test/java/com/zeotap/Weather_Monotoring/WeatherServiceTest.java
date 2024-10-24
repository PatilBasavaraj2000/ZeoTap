package com.zeotap.Weather_Monotoring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import com.zeotap.Weather_Monotoring.model.DailySummary;
import com.zeotap.Weather_Monotoring.service.WeatherConfig;
import com.zeotap.Weather_Monotoring.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class WeatherServiceTest {

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
    public void testCalculateDailySummary() {
        // Mock the temperature tracking
        weatherService.trackTemperature(20.0);
        weatherService.trackTemperature(25.0);
        weatherService.trackTemperature(30.0);

        // Calculate daily summary
        DailySummary summary = weatherService.calculateDailySummary();

        // Assertions to validate expected values
        assertEquals(25.0, summary.getAverageTemperature(), 0.01);
        assertEquals(30.0, summary.getMaxTemperature(), 0.01);
        assertEquals(20.0, summary.getMinTemperature(), 0.01);
    }

}
