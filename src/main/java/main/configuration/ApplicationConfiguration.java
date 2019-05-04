package main.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="app")
@Data
public class ApplicationConfiguration {

    @Data
    public static class Urls {
        String geolocation;
    }

    private Urls urls;
}


