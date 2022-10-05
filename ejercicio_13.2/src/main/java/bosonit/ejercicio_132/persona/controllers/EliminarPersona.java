package bosonit.ejercicio_132.persona.controllers;

import bosonit.ejercicio_132.persona.personaServices.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class EliminarPersona {
    @Autowired
    PersonaService ps;
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Integer id){
        ps.eliminarPersona(id);
    }
}
