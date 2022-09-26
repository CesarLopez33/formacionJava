package bosonit.ejercicio_72.student.repository;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,String> {
    Optional<Student> findByPersona(Persona persona);
}
