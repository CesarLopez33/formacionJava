package bosonit.ejercicio_72.services;

import bosonit.ejercicio_72.entities.Student;
import bosonit.ejercicio_72.repository.StudentRepository;
import bosonit.ejercicio_72.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StudentserviceImpl implements StudentService {
    @Autowired
    StudentRepository sr;

    @Override
    public void crearStudent(Student student) {sr.save(student);}

    @Override
    public Student actualizarStudent(String id, Student student) {
        Student s = sr.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado al estudiante con id: "+ id));
        sr.save(student);
        return student;
    }

    @Override
    public void eliminarStudent(String id) {
        try {
            sr.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No se ha encontrado al estudiante con id: " + id);
        }
    }

    @Override
    public Student obtenerStudent(String id) {
        return sr.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No se ha encontrado al estudiante con id: "+ id));
    }

    @Override
    public Student obtenerStudentPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<Student> obtenerTodasStudents() {
        return null;
    }
}
