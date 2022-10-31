package bosonit.ejercicio_16_Cloud.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;


@RestControllerAdvice
public class HandlerOfExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> exception(EntityNotFoundException ex) {
        CustomError customError = new CustomError(404,ex.getMessage());
        return ResponseEntity.status(404).body(customError);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> exception(UnprocessableEntityException ex) {
        CustomError customError = new CustomError(422,ex.getMessage());
        return ResponseEntity.status(422).body(customError);
    }
}
