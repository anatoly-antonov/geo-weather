package main.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import main.facade.GeoWeatherFacade;
import main.model.GeoWeatherResponse;
import main.model.geolocation.GeoLocationResponse;
import main.model.weather.WeatherDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class GeoWeatherController {

    private final GeoWeatherFacade facade;

    @ApiOperation(value = "Local weather search", response = GeoWeatherResponse.class)
    @GetMapping(path = "weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeoWeatherResponse> getWeather() {
        GeoWeatherResponse response = facade.getWeather();
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Geo location history", response = GeoLocationResponse.class)
    @GetMapping(path = "geolocation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeoLocationResponse>> getGeoLocations(
            @RequestParam(required = false) String ip) {
        List<GeoLocationResponse> response = facade.getGeoLocations(ip);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Weather data history", response = WeatherDTO.class)
    @GetMapping(path = "weatherData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WeatherDTO>> getWeatherData(
            @RequestParam(required = false) Double latitude,
            @RequestParam(required = false) Double longitude) {
        List<WeatherDTO> response = facade.getWeatherData(latitude, longitude);
        return ResponseEntity.ok(response);
    }
}

