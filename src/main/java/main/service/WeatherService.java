package main.service;

import lombok.AllArgsConstructor;
import main.configuration.ApplicationConfiguration;
import main.entity.WeatherResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@AllArgsConstructor
@Component
public class WeatherService {

    private final RestTemplate restTemplate;
    private final ApplicationConfiguration configuration;

    public WeatherResponse getWeather(Double lat, Double lon) {
        return restTemplate.getForObject(
                format(configuration.getUrls().getWeather(), lat, lon),
                WeatherResponse.class);
    }
}
