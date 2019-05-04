package main.controller;

import lombok.AllArgsConstructor;
import main.facade.GeoWeatherFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class GeoWeatherController {

    private final GeoWeatherFacade facade;

    @GetMapping(path = "weather")
    public String getWeather() {
        return facade.getWeather();
    }
}

