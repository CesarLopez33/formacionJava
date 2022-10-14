package bosonit.ejercicio_72.persona.controllers.persona.rest.template;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/persona")
public class ObtenerProfesorRestTemplate {

    @GetMapping(value="/profesor/{id}")
    public ResponseEntity<Object> obtenerProfesor(@PathVariable String id) {
        try{
            return new RestTemplate().getForEntity(
                    "http://localhost:8080/profesor/"+id, Object.class);
        }
        catch(HttpClientErrorException k1){
            return new ResponseEntity<>("El servidor no respondio con un 200, sino que lo hizo con un: "
                    + k1.getStatusCode() + " Causa: "+ k1.getResponseBodyAsString(),HttpStatus.BAD_REQUEST);
        }
        catch(RestClientException k){
            return new ResponseEntity<>( "El servidor no ha respondido. La causa es:\n " + k.getMessage()
                    ,HttpStatus.BAD_REQUEST);
        }
    }

}
