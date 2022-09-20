package bosonit.ejercicio_71;


import java.io.FileNotFoundException;

public interface PersonaService {
    void añadirPersona(Persona persona);
    Persona actualizarPersona(Persona persona,String id);
    Persona obtenerPersona(String id) throws FileNotFoundException;
    Persona obtenerPersonaPorNombre(String nombre) throws FileNotFoundException;
    void eliminarPersona(String id);

}
