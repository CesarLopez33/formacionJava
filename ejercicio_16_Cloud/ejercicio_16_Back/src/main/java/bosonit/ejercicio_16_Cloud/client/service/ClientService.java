package bosonit.ejercicio_16_Cloud.client.service;

import bosonit.ejercicio_16_Cloud.client.dtos.ClientInputDTO;
import bosonit.ejercicio_16_Cloud.client.dtos.ClientOutputDTO;

import java.util.List;

public interface ClientService {
    ClientOutputDTO createClient(ClientInputDTO client);
    ClientOutputDTO updateClient(ClientInputDTO client, Integer id);
    ClientOutputDTO obtainClient(Integer id);
    List<ClientOutputDTO> obtainAllClients();
    void deleteClient(Integer id);
}
