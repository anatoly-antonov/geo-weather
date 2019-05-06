package main.model.geolocation;

import main.AbstractObjectTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
public class GeoLocationResponseTest extends AbstractObjectTest<GeoLocationResponse> {

    @Test
    public void test_objectMethods() {
        LocalDateTime date = LocalDateTime.now();
        checkObjectMethods(prepare(date), prepare(date));
    }

    private GeoLocationResponse prepare(LocalDateTime date) {
        GeoLocationResponse response = new GeoLocationResponse();
        response.setId(1L);
        response.setDate(date);
        response.setCity("City");
        response.setCountry("Country");
        response.setLat(2D);
        response.setLon(3D);
        response.setQuery("IP");
        response.setTimezone("Timezone");
        return response;
    }
}
