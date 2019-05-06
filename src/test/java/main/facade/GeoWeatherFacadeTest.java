package main.facade;

import main.repository.GeoLocationRepository;
import main.repository.WeatherRepository;
import main.service.GeoLocationService;
import main.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void test() {
        facade.getWeatherData();
    }
}
