package main.model.weather;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeatherResponse implements Serializable {

    private Long visibility;
    private Coordinates coord;
    private Wind wind;
    private Conditions main;
    private List<Cloudiness> weather;
}
