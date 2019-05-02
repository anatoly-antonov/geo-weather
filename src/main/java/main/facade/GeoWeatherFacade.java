package main.facade;

import lombok.AllArgsConstructor;
import main.service.GeoWeatherService;
import main.service.LocationService;
import main.service.WeatherService;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GeoWeatherFacade {

    private final GeoWeatherService service;
    private final LocationService locationService;
    private final WeatherService weatherService;

    public String getWeather() {
        return "Weather";
    }
}
