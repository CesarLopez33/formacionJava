package bosonit.ejercicio_71.repositorio;

import bosonit.ejercicio_71.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonaRepository extends CrudRepository<Persona,String> {
    Optional<Persona> findFirstByNombre(String nombre);
}
