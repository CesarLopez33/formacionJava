package bosonit.ejercicio_72.persona.dtos;

import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaOutputDTO;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.student.Student;
import bosonit.ejercicio_72.student.dtos.output.StudentAsignaturasFullOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonaProfesorFullOutputDTO implements Serializable {
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
    private String id_profesor;
    private String comments;
    private String branch;
    private List<AsignaturaOutputDTO> asignaturas = new ArrayList<>();
    private List<StudentAsignaturasFullOutputDTO> students = new ArrayList<>();

    public PersonaProfesorFullOutputDTO(Profesor p) {
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
        this.id_profesor = p.getId_profesor();
        this.comments = p.getComments();
        this.branch = p.getBranch();
        this.asignaturas=p.getAsignaturas().stream().map(AsignaturaOutputDTO::new).toList();
        for(Student s : p.getStudents()){
            StudentAsignaturasFullOutputDTO aux = new StudentAsignaturasFullOutputDTO(s);
            students.add(aux);
        }

    }
}
