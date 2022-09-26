package bosonit.ejercicio_72.profesor.repository;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.profesor.Profesor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfesorRepository extends CrudRepository<Profesor,String> {
    Optional<Profesor> findByPersona(Persona persona);
}
