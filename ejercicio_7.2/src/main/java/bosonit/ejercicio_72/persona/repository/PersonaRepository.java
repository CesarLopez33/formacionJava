package bosonit.ejercicio_72.persona.repository;

import bosonit.ejercicio_72.persona.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.HashMap;
import java.util.List;
public interface PersonaRepository extends JpaRepository<Persona,Integer>, JpaSpecificationExecutor {
    List<Persona> findByName(String name);
    public List<Persona> getData(HashMap<String,Object> condiciones,int numPage,int pageSize);


}
