package main.model.geolocation;

import lombok.Data;

import java.io.Serializable;

@Data
public class GeoLocationResponse implements Serializable {

    private String city;
    private String country;
    private String query;
    private Double lat;
    private Double lon;
}
