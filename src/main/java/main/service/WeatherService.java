package main.service;

import lombok.AllArgsConstructor;
import main.configuration.ApplicationConfiguration;
import main.infrastructure.exception.ApplicationException;
import main.model.weather.WeatherDTO;
import main.model.weather.WeatherResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static java.lang.String.format;

@AllArgsConstructor
@Component
public class WeatherService {

    private final RestTemplate restTemplate;
    private final ApplicationConfiguration configuration;


    private WeatherResponse getRawWeatherData(Double lat, Double lon) {
        try {
            return restTemplate.getForObject(
                    format(configuration.getUrls().getWeather(), lat, lon),
                    WeatherResponse.class);
        } catch (Exception e) {
            throw new ApplicationException("Error getting weather data: "+ e.getMessage());
        }
    }

    @Cacheable("weather")
    public WeatherDTO getWeather(Double lat, Double lon) {
        WeatherResponse response = getRawWeatherData(lat, lon);
        if (response == null || response.getMain() == null || response.getCoord() == null || response.getWeather() == null) {
            throw new ApplicationException("No weather data available");
        }
        return WeatherDTO.builder()
                .date(LocalDateTime.now())
                .lon(response.getCoord().getLon())
                .lat(response.getCoord().getLat())
                .temperature(response.getMain().getTemp())
                .maximumTemperature(response.getMain().getTemp_max())
                .minimumTemperature(response.getMain().getTemp_min())
                .pressure(response.getMain().getPressure())
                .humidity(response.getMain().getHumidity())
                .windSpeed(response.getWind() != null ? response.getWind().getSpeed() : null)
                .cloudiness(response.getWeather().isEmpty() ? null : response.getWeather().stream()
                        .map(cloudiness -> cloudiness.getMain() +" - "+ cloudiness.getDescription())
                        .collect(Collectors.toList()))
                .build();
    }
}
