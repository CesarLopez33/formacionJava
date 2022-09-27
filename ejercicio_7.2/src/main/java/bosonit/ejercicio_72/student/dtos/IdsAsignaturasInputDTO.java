package bosonit.ejercicio_72.student.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IdsAsignaturasInputDTO implements Serializable {
    private List<String> ids;
}
