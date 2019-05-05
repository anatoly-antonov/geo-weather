package main.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.configuration.ApplicationConfiguration;
import main.infrastructure.exception.ApplicationException;
import main.model.geolocation.GeoLocationResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
@Slf4j
public class GeoLocationService {

    private final RestTemplate restTemplate;
    private final ApplicationConfiguration configuration;

    @Cacheable("geolocation")
    public GeoLocationResponse getLocation() {
        try {
            return restTemplate.getForObject(configuration.getUrls().getGeolocation(), GeoLocationResponse.class);
        } catch (Exception e) {
            throw new ApplicationException("Error getting geolocation data: "+ e.getMessage());
        }
    }
}
