package main;

import main.model.GeoWeatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test_contextLoads() {
        assertThat(restTemplate).isNotNull();
        assertThat(restTemplate.getForObject("http://localhost:"+ port +"/", String.class))
                .contains("Find out your local weather.");
    }

    @Test
    public void test_geoController_weather() {
        assertThat(restTemplate).isNotNull();
        assertThat(restTemplate.getForEntity("http://localhost:"+ port +"/weather", GeoWeatherResponse.class))
                .isNotNull();
    }

    @Test
    public void test_geoController_geolocation() {
        assertThat(restTemplate).isNotNull();
        assertThat(restTemplate.getForEntity("http://localhost:"+ port +"/geolocation", List.class))
                .isNotNull();
    }

    @Test
    public void test_geoController_weatherData() {
        assertThat(restTemplate).isNotNull();
        assertThat(restTemplate.getForEntity("http://localhost:"+ port +"/weatherData", List.class))
                .isNotNull();
    }
}
