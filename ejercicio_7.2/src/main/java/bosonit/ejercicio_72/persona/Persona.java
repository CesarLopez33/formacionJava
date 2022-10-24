package bosonit.ejercicio_72.persona;

import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@NoArgsConstructor
public class Persona implements java.io.Serializable {
    @Id
    @GeneratedValue
    private Integer id_persona;
    @Column
    private String usuario;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String company_email;
    @Column
    private String personal_email;
    @Column
    private String city;
    @Column
    private Boolean active;
    @Column
    private Date created_date;
    @Column
    private String imagen_url;
    @Column
    private Boolean admin;
    @Column
    private Date termination_date;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "persona")
    @JsonBackReference(value = "personaStudent")
    private Student student;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "persona")
    @JsonBackReference(value = "personaProfesor")
    private Profesor profesor;

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
        this.admin=p.getAdmin();
    }
}
