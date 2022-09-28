package bosonit.ejercicio_72.student.dtos;

import bosonit.ejercicio_72.student.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class StudentPersonaOutputDTO implements Serializable {
    private String id_student;
    private Integer num_hours_week;
    private String coments;
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

    public StudentPersonaOutputDTO(Student s) {
        this.id_student = s.getId_student();
        this.num_hours_week = s.getNum_hours_week();
        this.coments = s.getComments();
        if(s.getPersona()!=null) {
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
        }
    }
}
