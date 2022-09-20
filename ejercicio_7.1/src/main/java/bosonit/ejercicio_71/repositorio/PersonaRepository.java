package bosonit.ejercicio_71.repositorio;

import bosonit.ejercicio_71.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona,String> {
}
