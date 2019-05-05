package main.model.geolocation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity(name = "geoLocation")
public class GeoLocationResponse implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String country;
    private String query;
    private String timezone;
    private LocalDateTime date;
    private Double lat;
    private Double lon;
}
