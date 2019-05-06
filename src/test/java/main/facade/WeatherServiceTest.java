package main.facade;

import main.configuration.ApplicationConfiguration;
import main.infrastructure.exception.ApplicationException;
import main.model.weather.*;
import main.service.WeatherService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class WeatherServiceTest {

    private final String url = "lat=%s&lon=%s";
    private final Double lat = 1D;
    private final Double lon = 2D;

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ApplicationConfiguration configuration;
    @InjectMocks
    private WeatherService service;

    @Before
    public void init() {
        ApplicationConfiguration.Urls urls = mock(ApplicationConfiguration.Urls.class);
        when(configuration.getUrls()).thenReturn(urls);
        when(urls.getWeather()).thenReturn(url);
    }

    @Test(expected = ApplicationException.class)
    public void test_getWeather_getRawWeatherData_exception() {
        when(restTemplate.getForObject("lat=1.0&lon=2.0", WeatherResponse.class)).thenThrow(new RestClientException("oops"));
        service.getWeather(lat, lon);
    }

    @Test(expected = ApplicationException.class)
    public void test_getWeather_response_null() {
        when(restTemplate.getForObject("lat=1.0&lon=2.0", WeatherResponse.class)).thenReturn(null);
        service.getWeather(lat, lon);
    }

    @Test(expected = ApplicationException.class)
    public void test_getWeather_response_main_null() {
        when(restTemplate.getForObject("lat=1.0&lon=2.0", WeatherResponse.class)).thenReturn(mock(WeatherResponse.class));
        service.getWeather(lat, lon);
    }

    @Test(expected = ApplicationException.class)
    public void test_getWeather_response_coord_null() {
        WeatherResponse mockResponse = mock(WeatherResponse.class);

        when(mockResponse.getMain()).thenReturn(mock(Conditions.class));
        when(mockResponse.getCoord()).thenReturn(null);
        when(restTemplate.getForObject("lat=1.0&lon=2.0", WeatherResponse.class)).thenReturn(mockResponse);
        service.getWeather(lat, lon);
    }

    @Test(expected = ApplicationException.class)
    public void test_getWeather_response_weather_null() {
        WeatherResponse mockResponse = mock(WeatherResponse.class);

        when(mockResponse.getMain()).thenReturn(mock(Conditions.class));
        when(mockResponse.getCoord()).thenReturn(mock(Coordinates.class));
        when(mockResponse.getWeather()).thenReturn(null);
        when(restTemplate.getForObject("lat=1.0&lon=2.0", WeatherResponse.class)).thenReturn(mockResponse);
        service.getWeather(lat, lon);
    }

    @Test
    public void test_getWeather() {
        WeatherResponse weatherResponse = new WeatherResponse();
        Conditions conditions = new Conditions();
        Coordinates coordinates = new Coordinates();
        Cloudiness cloudiness = new Cloudiness();
        Wind wind = new Wind();

        conditions.setTemp(1D);
        conditions.setTemp_max(2D);
        conditions.setTemp_min(3D);
        conditions.setHumidity(4);
        conditions.setPressure(5L);

        cloudiness.setMain("Clear");
        cloudiness.setDescription("clear sky");

        coordinates.setLat(lat);
        coordinates.setLon(lon);

        wind.setSpeed(6D);

        weatherResponse.setMain(conditions);
        weatherResponse.setCoord(coordinates);
        weatherResponse.setWeather(Lists.newArrayList(cloudiness));
        weatherResponse.setWind(wind);
        weatherResponse.setVisibility(7L);

        when(restTemplate.getForObject("lat=1.0&lon=2.0", WeatherResponse.class)).thenReturn(weatherResponse);

        WeatherDTO result = service.getWeather(lat, lon);
        assertNotNull(result);
        assertNotNull(result.getDate());
        assertEquals(1D, result.getTemperature(), 0);
        assertEquals(2D, result.getMaximumTemperature(), 0);
        assertEquals(3D, result.getMinimumTemperature(), 0);
        assertEquals(4, result.getHumidity(), 0);
        assertEquals(5L, result.getPressure(), 0);
        assertEquals(6D, result.getWindSpeed(), 0);
        assertEquals(7L, result.getVisibility(), 0);
        assertEquals(lat, result.getLat(), 0);
        assertEquals(lon, result.getLon(), 0);
        assertEquals(1, result.getCloudiness().size());
        assertEquals("Clear - clear sky", result.getCloudiness().get(0));
    }
}
