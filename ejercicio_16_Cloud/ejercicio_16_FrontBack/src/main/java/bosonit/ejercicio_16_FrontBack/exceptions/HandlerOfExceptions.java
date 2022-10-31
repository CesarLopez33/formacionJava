package bosonit.ejercicio_16_FrontBack.exceptions;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class HandlerOfExceptions{

    @ExceptionHandler(BackErrorException.class)
    public CustomError exception(BackErrorException ex) {
        return new CustomError(400,ex.getMessage().substring(ex.getMessage().indexOf("mensaje")));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public CustomError exception(EntityNotFoundException ex) {
        return new CustomError(400,ex.getMessage());
    }
}
