package main.model.weather;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeatherResponse implements Serializable {

    private List<Weather> weather;
}
