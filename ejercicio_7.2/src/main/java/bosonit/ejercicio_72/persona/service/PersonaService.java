package bosonit.ejercicio_72.persona.service;

import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

public interface PersonaService {

    PersonaOutputDTO crearPersona(PersonaInputDTO persona);
    PersonaOutputDTO actualizarPersona(Integer id,PersonaInputDTO persona);
    void eliminarPersona(Integer id);
    PersonaOutputDTO obtenerPersona(Integer id);
    ResponseEntity<Object> obtenerPersonaConTodo(Integer id);
    List<PersonaOutputDTO> obtenerPersonaPorNombre(String nombre);
    ResponseEntity<Object> obtenerPersonaPorNombreConTodo(String nombre);
    List<PersonaOutputDTO> obtenerTodasPersonas();
    ResponseEntity<Object> obtenerTodasPersonaConTodo();

    List<PersonaOutputDTO> obtenerPersonaPorCriterio(HashMap<String, Object> condiciones,int numPage,int pageSize);
}
