package main.service;

import lombok.AllArgsConstructor;
import main.configuration.ApplicationConfiguration;
import main.entity.weather.WeatherResponse;
import main.infrastructure.exception.ApplicationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@AllArgsConstructor
@Component
public class WeatherService {

    private final RestTemplate restTemplate;
    private final ApplicationConfiguration configuration;

    public WeatherResponse getWeather(Double lat, Double lon) {
        try {
            return restTemplate.getForObject(
                    format(configuration.getUrls().getWeather(), lat, lon),
                    WeatherResponse.class);
        } catch (Exception e) {
            throw new ApplicationException("Error getting weather data: "+ e.getMessage());
        }
    }
}
