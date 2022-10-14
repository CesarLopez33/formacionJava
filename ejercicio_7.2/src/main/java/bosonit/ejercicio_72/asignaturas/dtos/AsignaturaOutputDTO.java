package bosonit.ejercicio_72.asignaturas.dtos;

import bosonit.ejercicio_72.asignaturas.Asignatura;
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

    public AsignaturaOutputDTO(Asignatura e) {
        this.asignatura = e.getAsignaturaName();
        this.comments = e.getComments();
        this.initial_date = e.getInitial_date();
        this.finish_date = e.getFinish_date();
    }
}
