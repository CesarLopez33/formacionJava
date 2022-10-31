package bosonit.ejercicio_16_Cloud.client.controllers;

import bosonit.ejercicio_16_Cloud.client.dtos.ClientInputDTO;
import bosonit.ejercicio_16_Cloud.client.dtos.ClientOutputDTO;
import bosonit.ejercicio_16_Cloud.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientPostController {
    @Autowired
    ClientService clientService;

    @PostMapping
    public ClientOutputDTO postClient(@RequestBody ClientInputDTO client){
        return clientService.createClient(client);
    }

}
