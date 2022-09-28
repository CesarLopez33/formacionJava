package bosonit.ejercicio_72.persona.controllersPersona;

import bosonit.ejercicio_72.profesor.dtos.ProfesorOutputDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/persona")
public class ObtenerProfesorDesdePersona {

    @GetMapping(value="/profesor/{id}")
    public ProfesorOutputDTO obtenerProfesor(@PathVariable String id) {
        ResponseEntity<ProfesorOutputDTO> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8080/profesor/"+id, ProfesorOutputDTO.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity.getBody();
        }
        throw new RuntimeException("El servidor no ha respondido con un 200");
    }

}
