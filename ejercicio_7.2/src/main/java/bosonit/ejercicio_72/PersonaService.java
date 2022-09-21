package bosonit.ejercicio_72;


import java.io.FileNotFoundException;
import java.util.List;

public interface PersonaService {

    void crearPersona(Persona persona);
    Persona actualizarPersona(Integer id,Persona persona);
    Persona obtenerPersona(Integer id) throws FileNotFoundException;
    void eliminarPersona(Integer id);
    List<Persona> obtenerTodasPersonas();
    Persona obtenerPersonaPorNombre(String nombre) throws FileNotFoundException;
}
