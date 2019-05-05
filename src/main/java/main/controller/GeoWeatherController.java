package main.controller;

import lombok.AllArgsConstructor;
import main.entity.GeoWeatherResponse;
import main.facade.GeoWeatherFacade;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class GeoWeatherController {

    private final GeoWeatherFacade facade;

    @GetMapping(path = "weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeoWeatherResponse> getWeather() {
        GeoWeatherResponse response = facade.getWeather();
        return ResponseEntity.ok(response);
    }
}

