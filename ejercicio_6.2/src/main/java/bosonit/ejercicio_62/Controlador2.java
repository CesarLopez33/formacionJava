package bosonit.ejercicio_62;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/controlador2")
public class Controlador2 {

    @Autowired
    PersonaService ps;
    @Autowired
    List<Ciudad> ciudades;

    @GetMapping(value="getPersona")
    public Persona getPersona(){
        Persona persona = ps.getPersona();
        return new Persona(persona.getNombre(),persona.getPoblacion(), persona.getEdad()*2);
    }

    @GetMapping(value="getCiudad")
    public List<Ciudad> getCiudad(){
        return ciudades;
    }

}
