package main.service;

import lombok.AllArgsConstructor;
import main.configuration.ApplicationConfiguration;
import main.entity.GeoLocationResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class GeoLocationService {

    private final RestTemplate restTemplate;
    private final ApplicationConfiguration configuration;

    public GeoLocationResponse getLocation() {
        return restTemplate.getForObject(configuration.getUrls().getGeolocation(), GeoLocationResponse.class);
    }
}
