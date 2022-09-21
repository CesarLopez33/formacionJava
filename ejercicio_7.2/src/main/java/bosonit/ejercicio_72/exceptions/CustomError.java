package bosonit.ejercicio_72.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError implements java.io.Serializable{
    private Date timeStamp;
    private Integer httpCode;
    private String mensaje;

    public CustomError(int httpCode, String mensaje) {
        this.timeStamp= new Date();
        this.httpCode = httpCode;
        this.mensaje = mensaje;
    }
}
