package bosonit.ejercicio_72.persona.repository;

import bosonit.ejercicio_72.persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;
public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    List<Persona> findByName(String name);
    public List<Persona> getData(HashMap<String,Object> condiciones,int numPage,int pageSize);


}
