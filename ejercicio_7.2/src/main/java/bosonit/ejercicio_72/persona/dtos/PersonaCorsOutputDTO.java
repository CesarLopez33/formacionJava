package bosonit.ejercicio_72.persona.dtos;

import bosonit.ejercicio_72.persona.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;

@Data
@NoArgsConstructor
public class PersonaCorsOutputDTO {
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private LocalDate created_date;
    private String imagen_url;
    private LocalDate termination_date;

    public PersonaCorsOutputDTO(PersonaOutputDTO p) {
        this.usuario = p.getUsuario();
        this.password = p.getPassword();
        this.name = p.getName();
        this.surname = p.getSurname();
        this.company_email = p.getCompany_email();
        this.personal_email = p.getPersonal_email();
        this.city = p.getCity();
        this.active = p.getActive();
        this.created_date = p.getCreated_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.imagen_url = p.getImagen_url();
        this.termination_date = p.getTermination_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
