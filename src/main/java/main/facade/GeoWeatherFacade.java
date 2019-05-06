package main.facade;

import lombok.AllArgsConstructor;
import main.model.GeoWeatherResponse;
import main.model.Status;
import main.model.geolocation.GeoLocationResponse;
import main.model.weather.WeatherDTO;
import main.repository.GeoLocationRepository;
import main.repository.WeatherRepository;
import main.service.GeoLocationService;
import main.service.WeatherService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class GeoWeatherFacade {

    private final GeoLocationService geoLocationService;
    private final GeoLocationRepository geoLocationRepository;
    private final WeatherService weatherService;
    private final WeatherRepository weatherRepository;

    public GeoWeatherResponse getWeather() {
        GeoLocationResponse geoResponse = geoLocationService.getLocation();
        WeatherDTO weather = weatherService.getWeather(geoResponse.getLat(), geoResponse.getLon());

        geoLocationRepository.save(geoResponse);
        weatherRepository.save(weather);

        return GeoWeatherResponse.builder()
                .date(LocalDateTime.now())
                .status(Status.SUCCESS.getName())
                .geoData(geoResponse)
                .weatherData(weather)
                .build();
    }

    public List<GeoLocationResponse> getGeoLocations(String ipAddress) {
        List<GeoLocationResponse> list = new ArrayList<>();
        if (ipAddress != null) {
            geoLocationRepository.findByQuery(ipAddress).iterator().forEachRemaining(list::add);
        } else {
            geoLocationRepository.findAll().iterator().forEachRemaining(list::add);
        }
        return list;
    }

    public List<WeatherDTO> getWeatherData(Double lat, Double lon) {
        List<WeatherDTO> list = new ArrayList<>();
        if (lat != null && lon != null) {
            weatherRepository.findByCoordinates(lat, lon).iterator().forEachRemaining(list::add);
        } else {
            weatherRepository.findAll().iterator().forEachRemaining(list::add);
        }
        return list;
    }
}
