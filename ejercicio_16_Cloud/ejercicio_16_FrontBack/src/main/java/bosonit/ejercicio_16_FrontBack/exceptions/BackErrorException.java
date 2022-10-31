package bosonit.ejercicio_16_FrontBack.exceptions;

import javax.persistence.PersistenceException;

public class BackErrorException extends PersistenceException {
    public BackErrorException(String message) {
        super(message);
    }
}
