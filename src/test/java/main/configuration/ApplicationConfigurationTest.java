package main.configuration;

import main.AbstractObjectTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ApplicationConfigurationTest extends AbstractObjectTest<ApplicationConfiguration> {

    @Test
    public void test_objectMethods() {
        ApplicationConfiguration configuration1 = new ApplicationConfiguration();
        ApplicationConfiguration.Urls urls1 = new ApplicationConfiguration.Urls();
        urls1.setGeolocation("geo");
        urls1.setWeather("weather");
        configuration1.setUrls(urls1);

        ApplicationConfiguration configuration2 = new ApplicationConfiguration();
        ApplicationConfiguration.Urls urls2 = new ApplicationConfiguration.Urls();
        urls2.setGeolocation("geo");
        urls2.setWeather("weather");
        configuration2.setUrls(urls2);

        checkObjectMethods(configuration1, configuration2);
    }
}
