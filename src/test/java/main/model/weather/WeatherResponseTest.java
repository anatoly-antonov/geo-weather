package main.model.weather;

import main.AbstractObjectTest;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class WeatherResponseTest extends AbstractObjectTest<WeatherResponse> {

    @Test
    public void test_objectMethods() {
        checkObjectMethods(prepare(), prepare());
    }

    private WeatherResponse prepare() {
        WeatherResponse response1 = new WeatherResponse();

        Coordinates coordinates1 = new Coordinates();
        coordinates1.setLat(1D);
        coordinates1.setLon(2D);
        response1.setCoord(coordinates1);

        Conditions conditions1 = new Conditions();
        conditions1.setHumidity(3);
        conditions1.setPressure(4L);
        conditions1.setTemp(5D);
        conditions1.setTemp_max(6D);
        conditions1.setTemp_min(7D);
        response1.setMain(conditions1);

        response1.setVisibility(8L);

        Wind wind1 = new Wind();
        wind1.setSpeed(9D);
        response1.setWind(wind1);

        Cloudiness cloudiness1 = new Cloudiness();
        cloudiness1.setDescription("CCC");
        cloudiness1.setMain("C");
        response1.setWeather(Lists.newArrayList(cloudiness1));

        return response1;
    }
}
