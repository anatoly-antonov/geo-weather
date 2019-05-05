package main.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.configuration.ApplicationConfiguration;
import main.entity.geolocation.GeoLocationResponse;
import main.infrastructure.exception.ApplicationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
@Slf4j
public class GeoLocationService {

    private final RestTemplate restTemplate;
    private final ApplicationConfiguration configuration;

    public GeoLocationResponse getLocation() {
        try {
            return restTemplate.getForObject(configuration.getUrls().getGeolocation(), GeoLocationResponse.class);
        } catch (Exception e) {
            throw new ApplicationException("Error getting geolocation data: "+ e.getMessage());
        }
    }
}
