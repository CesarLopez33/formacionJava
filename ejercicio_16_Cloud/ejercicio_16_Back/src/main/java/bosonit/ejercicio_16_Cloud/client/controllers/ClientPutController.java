package bosonit.ejercicio_16_Cloud.client.controllers;

import bosonit.ejercicio_16_Cloud.client.dtos.ClientInputDTO;
import bosonit.ejercicio_16_Cloud.client.dtos.ClientOutputDTO;
import bosonit.ejercicio_16_Cloud.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientPutController {
    @Autowired
    ClientService clientService;

    @PutMapping("/{id}")
    public ClientOutputDTO putClient(@PathVariable Integer id, @RequestBody ClientInputDTO client){
        return clientService.updateClient(client,id);
    }

}
