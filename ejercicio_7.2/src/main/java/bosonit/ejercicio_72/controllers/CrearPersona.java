package bosonit.ejercicio_72.controllers;

import bosonit.ejercicio_72.Persona;
import bosonit.ejercicio_72.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class CrearPersona {

    @Autowired
    PersonaService ps;

    @PostMapping()
    void crearPersona(@RequestBody Persona p) {
        ps.crearPersona(p);
    }
}
