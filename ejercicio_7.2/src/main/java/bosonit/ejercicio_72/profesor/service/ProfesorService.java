package bosonit.ejercicio_72.profesor.service;

import bosonit.ejercicio_72.profesor.dtos.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.dtos.ProfesorOutputDTO;
import bosonit.ejercicio_72.profesor.dtos.ProfesorPersonaOutputDTO;

public interface ProfesorService {
    ProfesorOutputDTO crearProfesor(ProfesorInputDTO profesor);
    ProfesorOutputDTO obtenerProfesor(String id);
    ProfesorPersonaOutputDTO obtenerProfesorPersona(String id);
    ProfesorOutputDTO actualizarProfesor(ProfesorInputDTO profesor, String id);
    void eliminarProfesor(String id);
}
