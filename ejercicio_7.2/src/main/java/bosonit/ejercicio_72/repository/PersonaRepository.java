package bosonit.ejercicio_72.repository;

import bosonit.ejercicio_72.entities.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonaRepository extends CrudRepository<Persona,Integer> {
    Optional<Persona> findFirstByName(String name);
}
