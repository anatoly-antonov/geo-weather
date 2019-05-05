package main.entity;

import lombok.Builder;
import lombok.Data;
import main.entity.geolocation.GeoLocationResponse;
import main.entity.weather.WeatherResponse;

import java.time.LocalDateTime;

@Builder
@Data
public class GeoWeatherResponse {

    private LocalDateTime date;
    private String status;
    private String error;
    private GeoLocationResponse geoData;
    private WeatherResponse weatherData;
}
