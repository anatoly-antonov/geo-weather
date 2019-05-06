package main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.geolocation.GeoLocationResponse;
import main.model.weather.WeatherDTO;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GeoWeatherResponse {

    private LocalDateTime date;
    private String status;
    private String error;
    private GeoLocationResponse geoData;
    private WeatherDTO weatherData;
}
