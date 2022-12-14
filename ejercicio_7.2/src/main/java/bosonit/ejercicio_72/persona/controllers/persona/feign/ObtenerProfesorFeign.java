package bosonit.ejercicio_72.persona.controllers.persona.feign;

import bosonit.ejercicio_72.feign.IFeignServer;
import bosonit.ejercicio_72.profesor.dtos.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persona")
public class ObtenerProfesorFeign {
    @Autowired
    IFeignServer iFeignServer;

    @GetMapping(value="/profesor/server/{id}")
    public ResponseEntity<ProfesorOutputDTO> obtenerProfesor(@PathVariable String id) {
        return iFeignServer.getProfesor(id);
    }

}
