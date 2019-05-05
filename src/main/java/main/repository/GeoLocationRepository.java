package main.repository;

import main.model.geolocation.GeoLocationResponse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GeoLocationRepository extends CrudRepository<GeoLocationResponse, Long> {
    List<GeoLocationResponse> findByQuery(String query);
}
