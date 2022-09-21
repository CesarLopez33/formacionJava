package bosonit.ejercicio_72.controllers;

import bosonit.ejercicio_72.Persona;
import bosonit.ejercicio_72.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class ObtenerPersona {

    @Autowired
    PersonaService ps;

    @GetMapping("/{id}")
    Persona obtenerPersona(@PathVariable Integer id) throws FileNotFoundException {
        return ps.obtenerPersona(id);
    }
    @GetMapping("/nombre/{nombre}")
    Persona obtenerPersonaPorNombre(@PathVariable String nombre) throws FileNotFoundException {
        return ps.obtenerPersonaPorNombre(nombre);
    }
    @GetMapping("/all")
    List<Persona> obtenerTodasPersonas() {
        return ps.obtenerTodasPersonas();
    }
}
