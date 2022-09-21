package bosonit.ejercicio_71;

import bosonit.ejercicio_71.repositorio.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class PersonaServiceImple implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void añadirPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Persona persona,String id) {
        try {
            Persona p = obtenerPersona(id);

            if(!(persona.getNombre()==null)) p.setNombre(persona.getNombre());
            if(!(persona.getEdad()==null)) p.setEdad(persona.getEdad());
            if(!(persona.getPoblacion()==null)) p.setPoblacion(persona.getPoblacion());

            return personaRepository.save(p);
        }catch (FileNotFoundException personaNotFound){
            System.out.println("No existe ninguna persona con id: "+id);
            return null;
        }
    }

    @Override
    public Persona obtenerPersona(String id) throws FileNotFoundException{
        return personaRepository.findById(id).orElseThrow(()->new FileNotFoundException("Persona no encontrada"));
    }

    @Override
    public Persona obtenerPersonaPorNombre(String nombre) throws FileNotFoundException{
        return personaRepository.findFirstByNombre(nombre).orElseThrow(()->new FileNotFoundException("Persona no encontrada"));
    }

    @Override
    public void eliminarPersona(String id) {
        personaRepository.deleteById(id);
    }
}
