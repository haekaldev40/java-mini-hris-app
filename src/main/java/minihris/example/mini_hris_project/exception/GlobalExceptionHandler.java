package minihris.example.mini_hris_project.exception;

import minihris.example.mini_hris_project.common.CustomApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${app.version}")
    private String appVersion;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        CustomApiResponse<Object> response = new CustomApiResponse<>(
                "error",
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now().toString(),
                HttpStatus.NOT_FOUND.value(),
                appVersion,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomApiResponse<Object>> handleGlobalException(Exception ex, WebRequest request) {
        CustomApiResponse<Object> response = new CustomApiResponse<>(
                "error",
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now().toString(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                appVersion,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}