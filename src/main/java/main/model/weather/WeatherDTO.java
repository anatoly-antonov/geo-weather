package main.model.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "weather")
public class WeatherDTO {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime date;
    private Double lon;
    private Double lat;
    private Double temperature;
    private Double minimumTemperature;
    private Double maximumTemperature;
    private Long pressure;
    private Integer humidity;
    private Double windSpeed;
    private Long visibility;
    @ElementCollection
    private List<String> cloudiness;
}
