package bosonit.ejercicio_72.student.service;

import bosonit.ejercicio_72.asignaturas.repositories.AsignaturaRepository;
import bosonit.ejercicio_72.exceptions.UnprocessableEntityException;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import bosonit.ejercicio_72.profesor.repository.ProfesorRepository;
import bosonit.ejercicio_72.student.dtos.input.IdsAsignaturasInputDTO;
import bosonit.ejercicio_72.student.dtos.input.StudentInputDTO;
import bosonit.ejercicio_72.student.Student;
import bosonit.ejercicio_72.student.dtos.output.StudentOutputDTO;
import bosonit.ejercicio_72.student.dtos.output.StudentPersonaOutputDTO;
import bosonit.ejercicio_72.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class StudentserviceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public StudentOutputDTO crearStudent(StudentInputDTO student) {
        if(student.getNum_hours_week()==null) throw new UnprocessableEntityException("Num_hours_week no puede ser nulo");
        if(student.getBranch()==null) throw new UnprocessableEntityException("Branch no puede ser nulo");
        if(student.getId_persona()==null) throw new UnprocessableEntityException("id_persona no puede ser nulo");
        Student s = new Student(student);
        Persona p = personaRepository.findById(student.getId_persona()).orElseThrow(()->
                new EntityNotFoundException("No se ha encontrado persona con id "+ student.getId_persona()));
        if (p.getStudent()==null && p.getProfesor()==null) {
            s.setPersona(p);
        }else throw new UnprocessableEntityException("La persona con id "+student.getId_persona()+" ya esta asignada");
        s.setProfesor(profesorRepository.findById(student.getId_profesor()).orElseThrow(()->
                new EntityNotFoundException("No se ha encontrado profesor con id "+ student.getId_profesor())));
        studentRepository.save(s);
        return new StudentOutputDTO(s);
    }

    @Override
    public StudentOutputDTO actualizarStudent(String id, StudentInputDTO student) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado al estudiante con id: "+ id));
        if(student.getBranch()!=null) s.setBranch(student.getBranch());
        if(student.getComments()!=null) s.setComments(student.getComments());
        if(student.getNum_hours_week()!=null) s.setNum_hours_week(student.getNum_hours_week());
        studentRepository.save(s);
        return new StudentOutputDTO(s);
    }

    @Override
    public void eliminarStudent(String id) {
        try {
            studentRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No se ha encontrado al estudiante con id: " + id);
        }
    }

    @Override
    public StudentOutputDTO obtenerStudent(String id) {
        return new StudentOutputDTO(studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado al estudiante con id: "+ id)));
    }

    @Override
    public StudentPersonaOutputDTO obtenerStudentPersona(String id) {
        return new StudentPersonaOutputDTO(studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado al estudiante con id: "+ id)));
    }

    @Override
    public void addAsignaturas(String id, IdsAsignaturasInputDTO idsAsig) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado al estudiante con id: "+ id));
        idsAsig.getIds().forEach(idAsig-> student.getAsignaturas().add(asignaturaRepository.findById(idAsig)
                .orElseThrow(()-> new EntityNotFoundException("No se ha encontrado asignatura con id: "+idAsig))));
        studentRepository.save(student);
    }

    @Override
    public void deleteAsignaturas(String id, IdsAsignaturasInputDTO idsAsig) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado al estudiante con id: "+ id));
        idsAsig.getIds().forEach(idAsig-> student.getAsignaturas().remove(asignaturaRepository.findById(idAsig)
                .orElseThrow(()-> new EntityNotFoundException("No se ha encontrado asignatura con id: "+idAsig))));
        studentRepository.save(student);
    }
}
