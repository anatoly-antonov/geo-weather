package main.infrastructure;

import main.entity.GeoWeatherResponse;
import main.entity.Status;
import main.infrastructure.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<GeoWeatherResponse> handleError(ApplicationException e) {
        return ResponseEntity.ok(
                GeoWeatherResponse.builder()
                        .date(LocalDateTime.now())
                        .status(Status.ERROR.getName())
                        .error(e.getMessage())
                        .build()
        );
    }
}
