package main.service;

import main.configuration.ApplicationConfiguration;
import main.infrastructure.exception.ApplicationException;
import main.model.geolocation.GeoLocationResponse;
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
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class GeoLocationServiceTest {

    private final String url = "geoUrl";

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ApplicationConfiguration configuration;
    @InjectMocks
    private GeoLocationService service;

    @Before
    public void init() {
        ApplicationConfiguration.Urls urls = mock(ApplicationConfiguration.Urls.class);
        when(configuration.getUrls()).thenReturn(urls);
        when(urls.getGeolocation()).thenReturn(url);
    }

    @Test(expected = ApplicationException.class)
    public void test_getLocation_exception() {
        when(restTemplate.getForObject(url, GeoLocationResponse.class)).thenThrow(new RestClientException("Oops"));
        service.getLocation();
    }

    @Test(expected = ApplicationException.class)
    public void test_getLocation_null() {
        when(restTemplate.getForObject(url, GeoLocationResponse.class)).thenReturn(null);
        service.getLocation();
    }

    @Test
    public void test_getLocation() {
        GeoLocationResponse mockResponse = mock(GeoLocationResponse.class);
        when(restTemplate.getForObject(url, GeoLocationResponse.class)).thenReturn(mockResponse);

        GeoLocationResponse response = service.getLocation();
        verify(mockResponse).setDate(any());
        assertNotNull(response);
        assertEquals(mockResponse, response);
    }
}
