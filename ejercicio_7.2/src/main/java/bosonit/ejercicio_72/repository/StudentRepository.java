package bosonit.ejercicio_72.repository;

import bosonit.ejercicio_72.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,String> {
}
