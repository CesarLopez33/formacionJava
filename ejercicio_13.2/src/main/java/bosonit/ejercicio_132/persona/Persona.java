package bosonit.ejercicio_132.persona;

import bosonit.ejercicio_132.persona.dtos.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "persona")
public class Persona implements java.io.Serializable{
    @Id
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


    public Persona(PersonaInputDTO p) {
        this.usuario = p.getUsuario();
        this.password = p.getPassword();
        this.name = p.getName();
        this.surname = p.getSurname();
        this.company_email = p.getCompany_email();
        this.personal_email = p.getPersonal_email();
        this.city = p.getCity();
        this.active = p.getActive();
        this.created_date = p.getCreated_date();
        this.imagen_url = p.getImagen_url();
        this.termination_date = p.getTermination_date();
    }

}