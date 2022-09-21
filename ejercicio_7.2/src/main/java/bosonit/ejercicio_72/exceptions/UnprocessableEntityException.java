package bosonit.ejercicio_72.exceptions;

import javax.persistence.PersistenceException;

public class UnprocessableEntityException extends PersistenceException {
    public UnprocessableEntityException(String mensaje) {
        super(mensaje);
    }
}
