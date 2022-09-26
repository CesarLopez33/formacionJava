package bosonit.ejercicio_72.persona.service;

import bosonit.ejercicio_72.persona.Persona;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {

    void crearPersona(Persona persona);
    Persona actualizarPersona(Integer id,Persona persona);
    void eliminarPersona(Integer id);
    Persona obtenerPersona(Integer id);
    ResponseEntity obtenerPersonaConTodo(Integer id);
    List<Persona> obtenerPersonaPorNombre(String nombre);
    ResponseEntity obtenerPersonaPorNombreConTodo(String nombre);
    List<Persona> obtenerTodasPersonas();
    ResponseEntity obtenerTodasPersonaConTodo();

}
