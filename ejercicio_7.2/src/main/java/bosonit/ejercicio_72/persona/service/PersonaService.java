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
    ResponseEntity obtenerPersonaConTodo(Integer id);
    List<PersonaOutputDTO> obtenerPersonaPorNombre(String nombre);
    ResponseEntity obtenerPersonaPorNombreConTodo(String nombre);
    List<PersonaOutputDTO> obtenerTodasPersonas();
    ResponseEntity obtenerTodasPersonaConTodo();

    List<PersonaOutputDTO> obtenerPersonaPorCriterio(HashMap<String, Object> condiciones,int numPage,int pageSize);
}
