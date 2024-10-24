package com.zeotap.Weather_Monotoring;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.zeotap.Weather_Monotoring.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlertThresholdTest {

    private WeatherService weatherService;

    @BeforeEach
    public void setUp() {
        weatherService.setThreshold(35.0); // Set a threshold for testing
    }

    @Test
    void testAlertTriggered() {
        weatherService.trackTemperature(36.0); // This should trigger an alert
        assertTrue(weatherService.isAlertTriggered());
    }

    @Test
    void testNoAlertTriggered() {
        weatherService.trackTemperature(34.0); // This should not trigger an alert
        assertTrue(!weatherService.isAlertTriggered());
    }
}
