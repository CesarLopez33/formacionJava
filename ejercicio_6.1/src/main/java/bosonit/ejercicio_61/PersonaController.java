package bosonit.ejercicio_61;

import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {
    @GetMapping(value= "/user/{nombre}")
    public String usuarioNombre(@PathVariable String nombre){
        return "Hola " + nombre;
    }

    @PostMapping(value="/useradd")
    public Persona nuevaPersona(@RequestBody Persona p){
        p.setEdad(p.getEdad()+1);
        return p;
    }
}
