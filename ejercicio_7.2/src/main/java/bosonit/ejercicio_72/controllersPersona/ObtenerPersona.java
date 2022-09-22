package bosonit.ejercicio_72.controllersPersona;

import bosonit.ejercicio_72.entities.Persona;
import bosonit.ejercicio_72.services.PersonaService;
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
