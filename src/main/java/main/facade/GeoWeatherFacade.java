package main.facade;

import lombok.AllArgsConstructor;
import main.entity.GeoLocationResponse;
import main.service.GeoLocationService;
import main.service.GeoWeatherService;
import main.service.WeatherService;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GeoWeatherFacade {

    private final GeoWeatherService service;
    private final GeoLocationService geoLocationService;
    private final WeatherService weatherService;

    public String getWeather() {
        GeoLocationResponse geoResponse = geoLocationService.getLocation();
        return geoResponse.toString();
    }
}
