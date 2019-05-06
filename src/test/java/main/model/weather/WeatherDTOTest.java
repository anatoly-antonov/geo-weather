package main.model.weather;

import main.AbstractObjectTest;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
public class WeatherDTOTest extends AbstractObjectTest<WeatherDTO> {

    @Test
    public void test_objectMethods() {
        LocalDateTime date = LocalDateTime.now();
        checkObjectMethods(prepare(date), prepare(date));
    }

    private WeatherDTO prepare(LocalDateTime date) {
        return WeatherDTO.builder()
                .date(date)
                .lon(1D)
                .lat(2D)
                .temperature(3D)
                .maximumTemperature(4D)
                .minimumTemperature(5D)
                .pressure(6L)
                .humidity(7)
                .visibility(8L)
                .windSpeed(9D)
                .cloudiness(Lists.newArrayList("Clouds"))
                .build();
    }
}
