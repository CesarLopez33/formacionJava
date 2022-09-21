package bosonit.ejercicio_72.controllers;

import bosonit.ejercicio_72.Persona;
import bosonit.ejercicio_72.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ObtenerPersona {

    @Autowired
    PersonaService ps;

    @GetMapping("/{id}")
    Persona obtenerPersona(@PathVariable Integer id) {
        return ps.obtenerPersona(id);
    }
    @GetMapping("/nombre/{nombre}")
    Persona obtenerPersonaPorNombre(@PathVariable String nombre) {
        return ps.obtenerPersonaPorNombre(nombre);
    }
    @GetMapping("/all")
    List<Persona> obtenerTodasPersonas() {
        return ps.obtenerTodasPersonas();
    }
}
