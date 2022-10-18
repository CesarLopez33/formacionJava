package bosonit.ejercicio_72.profesor.dtos.output;

import bosonit.ejercicio_72.profesor.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProfesorPersonaOutputDTO {
    private String id_profesor;
    private String comments;
    private String branch;
    private Integer id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public ProfesorPersonaOutputDTO(Profesor p) {
        this.id_profesor = p.getId_profesor();
        this.comments = p.getComments();
        this.branch = p.getBranch();
        this.id_persona = p.getPersona().getId_persona();
        this.usuario = p.getPersona().getUsuario();
        this.password = p.getPersona().getPassword();
        this.name = p.getPersona().getName();
        this.surname = p.getPersona().getSurname();
        this.company_email = p.getPersona().getCompany_email();
        this.personal_email = p.getPersona().getPersonal_email();
        this.city = p.getPersona().getCity();
        this.active = p.getPersona().getActive();
        this.created_date = p.getPersona().getCreated_date();
        this.imagen_url = p.getPersona().getImagen_url();
        this.termination_date = p.getPersona().getTermination_date();
    }
}
