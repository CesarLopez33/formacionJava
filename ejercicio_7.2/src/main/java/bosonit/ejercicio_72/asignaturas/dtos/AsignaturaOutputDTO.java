package bosonit.ejercicio_72.asignaturas.dtos;

import bosonit.ejercicio_72.asignaturas.Estudiante_asignatura;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class AsignaturaOutputDTO {
    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;

    public AsignaturaOutputDTO(Estudiante_asignatura e) {
        this.asignatura = e.getAsignatura();
        this.comments = e.getComments();
        this.initial_date = e.getInitial_date();
        this.finish_date = e.getFinish_date();
    }
}
