package bosonit.ejercicio_16_Cloud.client.service;

import bosonit.ejercicio_16_Cloud.client.Client;
import bosonit.ejercicio_16_Cloud.client.dtos.ClientInputDTO;
import bosonit.ejercicio_16_Cloud.client.dtos.ClientOutputDTO;
import bosonit.ejercicio_16_Cloud.client.repository.ClientRepository;
import bosonit.ejercicio_16_Cloud.exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientOutputDTO createClient(ClientInputDTO client) {
        if(client.getName()==null) throw new UnprocessableEntityException("El nombre no puede ser nulo");
        if(client.getSurname()==null) throw new UnprocessableEntityException("El apellido no puede ser nulo");
        if(client.getEmail()==null) throw new UnprocessableEntityException("El email no puede ser nulo");
        if(client.getAge()==null) throw new UnprocessableEntityException("La edad no puede ser nula");
        return new ClientOutputDTO(clientRepository.save(new Client(client)));
    }

    @Override
    public ClientOutputDTO updateClient(ClientInputDTO clienteInput, Integer id) {
        Client c = clientRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun cliente con id: "+id));
        if (clienteInput.getName()!=null) c.setName(clienteInput.getName());
        if (clienteInput.getSurname()!=null) c.setSurname(clienteInput.getSurname());
        if (clienteInput.getAge()!=null) c.setAge(clienteInput.getAge());
        if (clienteInput.getEmail()!=null) c.setEmail(clienteInput.getEmail());
        if (clienteInput.getTelefone()!=null) c.setTelefone(clienteInput.getTelefone());
        return new ClientOutputDTO(clientRepository.save(c));
    }

    @Override
    public ClientOutputDTO obtainClient(Integer id) {
        return new ClientOutputDTO(clientRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun cliente con id: "+ id)));
    }

    @Override
    public List<ClientOutputDTO> obtainAllClients() {
        return clientRepository.findAll().stream().map(ClientOutputDTO::new).toList();
    }

    @Override
    public void deleteClient(Integer id) {
        try {
            clientRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No hay ningun cliente con id: "+id);
        }
    }
}
