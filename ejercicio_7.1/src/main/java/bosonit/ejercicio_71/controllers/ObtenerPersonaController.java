package bosonit.ejercicio_71.controllers;

import bosonit.ejercicio_71.Persona;
import bosonit.ejercicio_71.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value="/persona")
public class ObtenerPersonaController {
    @Autowired
    PersonaService ps;

    @GetMapping(value="{id}")
    public Persona obtenerPersona(@PathVariable String id) throws FileNotFoundException {
        return ps.obtenerPersona(id);
    }
    @GetMapping(value="/nombre/{nombre}")
    public Persona obtenerPersonaPorNombre(@PathVariable String nombre) throws FileNotFoundException {
        return ps.obtenerPersonaPorNombre(nombre);
    }

}
