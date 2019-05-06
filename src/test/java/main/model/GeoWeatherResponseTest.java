package main.model;

import main.AbstractObjectTest;
import main.model.geolocation.GeoLocationResponse;
import main.model.weather.WeatherDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
public class GeoWeatherResponseTest extends AbstractObjectTest<GeoWeatherResponse> {

    @Test
    public void test_objectMethods() {
        LocalDateTime date = LocalDateTime.now();
        checkObjectMethods(prepare(date), prepare(date));
    }

    private GeoWeatherResponse prepare(LocalDateTime date) {
        return GeoWeatherResponse.builder()
                .date(date)
                .status(Status.SUCCESS.getName())
                .error("Error")
                .geoData(new GeoLocationResponse())
                .weatherData(WeatherDTO.builder().build())
                .build();
    }


}
