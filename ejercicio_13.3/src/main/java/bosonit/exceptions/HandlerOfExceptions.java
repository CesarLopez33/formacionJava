package bosonit.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;


@RestControllerAdvice
public class HandlerOfExceptions {

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<CustomError> exception(StorageException ex) {
        CustomError customError = new CustomError(404,ex.getMessage());
        return ResponseEntity.status(404).body(customError);
    }

}
