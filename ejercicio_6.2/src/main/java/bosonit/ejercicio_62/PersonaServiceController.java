package bosonit.ejercicio_62;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceController implements PersonaService{
    @Autowired
    Persona persona;
    public Persona addNewPerson(String nombre, String poblacion, String edad){
        persona.setNombre(nombre);
        persona.setPoblacion(poblacion);
        persona.setEdad(Integer.parseInt(edad));
        return persona;
    }
    public Persona getPersona(){
        return persona;
    }
}
