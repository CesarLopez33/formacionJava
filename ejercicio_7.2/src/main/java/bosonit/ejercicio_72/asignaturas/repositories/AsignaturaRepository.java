package bosonit.ejercicio_72.asignaturas.repositories;

import bosonit.ejercicio_72.asignaturas.Estudiante_asignatura;
import bosonit.ejercicio_72.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Estudiante_asignatura,String> {
    List<Estudiante_asignatura> findByStudent(Student s);
}
