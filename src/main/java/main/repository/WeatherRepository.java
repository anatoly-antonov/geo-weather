package main.repository;

import main.model.weather.WeatherDTO;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<WeatherDTO, Long> {
}
