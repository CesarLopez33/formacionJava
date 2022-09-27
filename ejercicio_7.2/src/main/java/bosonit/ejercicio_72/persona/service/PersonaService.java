package bosonit.ejercicio_72.persona.service;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {

    void crearPersona(PersonaInputDTO persona);
    Persona actualizarPersona(Integer id,PersonaInputDTO persona);
    void eliminarPersona(Integer id);
    Persona obtenerPersona(Integer id);
    ResponseEntity obtenerPersonaConTodo(Integer id);
    List<Persona> obtenerPersonaPorNombre(String nombre);
    ResponseEntity obtenerPersonaPorNombreConTodo(String nombre);
    List<Persona> obtenerTodasPersonas();
    ResponseEntity obtenerTodasPersonaConTodo();

}
