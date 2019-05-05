package main.facade;

import lombok.AllArgsConstructor;
import main.model.GeoWeatherResponse;
import main.model.Status;
import main.model.geolocation.GeoLocationResponse;
import main.model.weather.WeatherResponse;
import main.service.GeoLocationService;
import main.service.WeatherService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class GeoWeatherFacade {

    private final GeoLocationService geoLocationService;
    private final WeatherService weatherService;

    public GeoWeatherResponse getWeather() {
        GeoLocationResponse geoResponse = geoLocationService.getLocation();
        WeatherResponse weatherResponse = weatherService.getWeather(geoResponse.getLat(), geoResponse.getLon());
        return GeoWeatherResponse.builder()
                .date(LocalDateTime.now())
                .status(Status.SUCCESS.getName())
                .geoData(geoResponse)
                .weatherData(weatherResponse)
                .build();
    }
}
