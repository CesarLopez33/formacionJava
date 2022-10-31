package bosonit.ejercicio_16_Cloud.client.controllers;

import bosonit.ejercicio_16_Cloud.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientDeleteController {
    @Autowired
    ClientService clientService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id){
        clientService.deleteClient(id);
        return new ResponseEntity<>("Cliente eliminado con exito",HttpStatus.OK);
    }
}
