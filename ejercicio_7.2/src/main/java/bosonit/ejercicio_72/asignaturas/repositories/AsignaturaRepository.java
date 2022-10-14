package bosonit.ejercicio_72.asignaturas.repositories;

import bosonit.ejercicio_72.asignaturas.Asignatura;
import bosonit.ejercicio_72.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface AsignaturaRepository extends JpaRepository<Asignatura,String> {
    List<Asignatura> findByStudent(Student s);
}
