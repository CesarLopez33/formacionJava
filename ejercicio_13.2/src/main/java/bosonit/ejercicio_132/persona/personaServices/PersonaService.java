package bosonit.ejercicio_132.persona.personaServices;

import bosonit.ejercicio_132.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_132.persona.dtos.PersonaOutputDTO;

import java.util.List;


public interface PersonaService {
    PersonaOutputDTO obtenerPersona(Integer id);
    PersonaOutputDTO crearPersona(PersonaInputDTO persona);
    PersonaOutputDTO actualizarPersona(Integer id, PersonaInputDTO persona);
    void eliminarPersona(Integer id);

    List<PersonaOutputDTO> obtenerTodasPersonas();

    List<PersonaOutputDTO> obtenerTodasPersonasPaginada(int pageSize, int numPage);
}
