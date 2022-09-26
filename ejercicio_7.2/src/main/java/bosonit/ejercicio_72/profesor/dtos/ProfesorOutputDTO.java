package bosonit.ejercicio_72.profesor.dtos;

import bosonit.ejercicio_72.profesor.Profesor;
import lombok.Data;

@Data
public class ProfesorOutputDTO {
    private String id_profesor;
    private Integer id_persona;
    private String comments;
    private String branch;

    public ProfesorOutputDTO(Profesor p) {
        this.id_profesor = p.getId_profesor();
        if(p.getPersona()!=null) this.id_persona = p.getPersona().getId_persona();
        this.comments = p.getComments();
        this.branch = p.getBranch();
    }
}
