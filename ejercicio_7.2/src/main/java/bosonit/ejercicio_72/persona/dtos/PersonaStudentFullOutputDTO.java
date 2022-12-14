package bosonit.ejercicio_72.persona.dtos;

import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaOutputDTO;
import bosonit.ejercicio_72.profesor.dtos.output.ProfesorOutputDTO;
import bosonit.ejercicio_72.student.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonaStudentFullOutputDTO implements Serializable {
    private Integer id_persona;
    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city ;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    private String id_student;
    private Integer num_hours_week;
    private String coments;
    private ProfesorOutputDTO profesor;
    private List<AsignaturaOutputDTO> asignaturas;

    public PersonaStudentFullOutputDTO(Student s) {
        this.id_persona = s.getPersona().getId_persona();
        this.user = s.getPersona().getUsuario();
        this.password = s.getPersona().getPassword();
        this.name = s.getPersona().getName();
        this.surname = s.getPersona().getSurname();
        this.company_email = s.getPersona().getCompany_email();
        this.personal_email = s.getPersona().getPersonal_email();
        this.city = s.getPersona().getCity();
        this.active = s.getPersona().getActive();
        this.created_date = s.getPersona().getCreated_date();
        this.imagen_url = s.getPersona().getImagen_url();
        this.termination_date = s.getPersona().getTermination_date();
        this.id_student = s.getId_student();
        this.num_hours_week = s.getNum_hours_week();
        this.coments = s.getComments();
        this.asignaturas = s.getAsignaturas().stream().map(AsignaturaOutputDTO::new).toList();
        this.profesor = new ProfesorOutputDTO(s.getProfesor());
    }
}
