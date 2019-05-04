package main.facade;

import lombok.AllArgsConstructor;
import main.entity.GeoLocationResponse;
import main.entity.WeatherResponse;
import main.service.GeoLocationService;
import main.service.WeatherService;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GeoWeatherFacade {

    private final GeoLocationService geoLocationService;
    private final WeatherService weatherService;

    public String getWeather() {
        GeoLocationResponse geoResponse = geoLocationService.getLocation();
        WeatherResponse weatherResponse = weatherService.getWeather(geoResponse.getLat(), geoResponse.getLon());
        return weatherResponse.toString();
    }
}
