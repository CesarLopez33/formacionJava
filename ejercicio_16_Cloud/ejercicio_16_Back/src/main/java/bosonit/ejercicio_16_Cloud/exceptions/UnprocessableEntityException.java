package bosonit.ejercicio_16_Cloud.exceptions;

import javax.persistence.PersistenceException;

public class UnprocessableEntityException extends PersistenceException {
    public UnprocessableEntityException(String mensaje) {
        super(mensaje);
    }
}
