package com.zeotap.Weather_Monotoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zeotap.Weather_Monotoring.service.WeatherService;
import org.junit.jupiter.api.Test;

public class TemperatureConversionTest {

    @Test
    void testKelvinToCelsius() {
        double kelvin = 300.15;
        double expectedCelsius = 27.0;
        assertEquals(expectedCelsius, WeatherService.convertKelvinToCelsius(kelvin), 0.01);
    }

    @Test
    void testKelvinToFahrenheit() {
        double kelvin = 300.15;
        double expectedFahrenheit = 80.6;
        assertEquals(expectedFahrenheit, WeatherService.convertKelvinToFahrenheit(kelvin), 0.01);
    }
}
