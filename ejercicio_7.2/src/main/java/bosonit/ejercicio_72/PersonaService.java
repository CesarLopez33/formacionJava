package bosonit.ejercicio_72;

import bosonit.ejercicio_72.exceptions.UnprocessableEntityException;
import java.util.List;

public interface PersonaService {

    void crearPersona(Persona persona);
    Persona actualizarPersona(Integer id,Persona persona);
    void eliminarPersona(Integer id);
    Persona obtenerPersona(Integer id);
    Persona obtenerPersonaPorNombre(String nombre);
    List<Persona> obtenerTodasPersonas();
}
