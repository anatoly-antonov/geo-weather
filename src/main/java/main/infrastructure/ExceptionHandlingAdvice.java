package main.infrastructure;

import main.infrastructure.exception.ApplicationException;
import main.model.GeoWeatherResponse;
import main.model.Status;
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
