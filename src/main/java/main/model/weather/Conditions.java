package main.model.weather;

import lombok.Data;

@Data
public class Conditions {

    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Long pressure;
    private Integer humidity;
}
