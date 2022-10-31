package bosonit.ejercicio_16_Cloud.client.controllers;

import bosonit.ejercicio_16_Cloud.client.dtos.ClientOutputDTO;
import bosonit.ejercicio_16_Cloud.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientGetController {
    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public ClientOutputDTO getClient(@PathVariable Integer id){
        return clientService.obtainClient(id);
    }

    @GetMapping("/all")
    public List<ClientOutputDTO> getAllClients(){
        return clientService.obtainAllClients();
    }

}
