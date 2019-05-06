package main.repository;

import main.model.weather.WeatherDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeatherRepository extends CrudRepository<WeatherDTO, Long> {

    @Query("select w from weather w where w.lat = :lat and w.lon = :lon")
    List<WeatherDTO> findByCoordinates(@Param("lat") Double lat, @Param("lon") Double lon);
}
