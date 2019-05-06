package main.facade;

import main.model.GeoWeatherResponse;
import main.model.Status;
import main.model.geolocation.GeoLocationResponse;
import main.model.weather.WeatherDTO;
import main.repository.GeoLocationRepository;
import main.repository.WeatherRepository;
import main.service.GeoLocationService;
import main.service.WeatherService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class GeoWeatherFacadeTest {

    @Mock
    private GeoLocationService geoLocationService;
    @Mock
    private GeoLocationRepository geoLocationRepository;
    @Mock
    private WeatherService weatherService;
    @Mock
    private WeatherRepository weatherRepository;

    @InjectMocks
    private GeoWeatherFacade facade;

    @Test
    public void test_getWeather() {
        GeoLocationResponse mockLocation = mock(GeoLocationResponse.class);
        WeatherDTO weatherDTO = mock(WeatherDTO.class);

        when(mockLocation.getLat()).thenReturn(1D);
        when(mockLocation.getLon()).thenReturn(2D);
        when(geoLocationService.getLocation()).thenReturn(mockLocation);
        when(weatherService.getWeather(1D, 2D)).thenReturn(weatherDTO);

        GeoWeatherResponse response = facade.getWeather();
        verify(geoLocationRepository).save(mockLocation);
        verify(weatherRepository).save(weatherDTO);
        assertNotNull(response);
        assertNotNull(response.getDate());
        assertNull(response.getError());
        assertEquals(Status.SUCCESS.getName(), response.getStatus());
        assertEquals(mockLocation, response.getGeoData());
        assertEquals(weatherDTO, response.getWeatherData());
    }

    @Test
    public void test_getGeoLocations() {
        GeoLocationResponse mockLocation1 = mock(GeoLocationResponse.class);
        GeoLocationResponse mockLocation2 = mock(GeoLocationResponse.class);
        Iterable iterable = mock(Iterable.class);

        when(geoLocationRepository.findAll()).thenReturn(iterable);
        when(iterable.iterator()).thenReturn(Lists.newArrayList(mockLocation1, mockLocation2).iterator());

        List<GeoLocationResponse> result = facade.getGeoLocations(null);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(mockLocation1, result.get(0));
        assertEquals(mockLocation2, result.get(1));
    }

    @Test
    public void test_getWeatherData() {
        WeatherDTO weatherDTO = mock(WeatherDTO.class);
        Iterable iterable = mock(Iterable.class);

        when(weatherRepository.findAll()).thenReturn(iterable);
        when(iterable.iterator()).thenReturn(Lists.newArrayList(weatherDTO).iterator());

        List<WeatherDTO> result = facade.getWeatherData();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(weatherDTO, result.get(0));
    }
}
