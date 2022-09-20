package bosonit.ejercicio_71.controllers;

import bosonit.ejercicio_71.Persona;
import bosonit.ejercicio_71.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/persona")
public class CrearPersonaController {
    @Autowired
    PersonaService ps;

    @PostMapping(value="/")
    public void añadirPersona(@RequestBody Persona p){
        ps.añadirPersona(p);
    }
}
