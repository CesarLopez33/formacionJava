package bosonit.ejercicio_16_FrontBack.ticket.service;

import bosonit.ejercicio_16_FrontBack.dtos.ClientOutputDTO;
import bosonit.ejercicio_16_FrontBack.dtos.TripFullOutputDTO;
import bosonit.ejercicio_16_FrontBack.exceptions.BackErrorException;
import bosonit.ejercicio_16_FrontBack.ticket.Ticket;
import bosonit.ejercicio_16_FrontBack.ticket.dtos.TicketOutputDTO;
import bosonit.ejercicio_16_FrontBack.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.net.URISyntaxException;

@Service
public class TicketServiceImpl implements TickerService{
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public TicketOutputDTO generateTicket(Integer clientId, Integer tripId) throws URISyntaxException {
        String url = "http://trip-service/trip/addPassenger/"+tripId+"/"+clientId;

        try {
            ResponseEntity<TripFullOutputDTO> response = restTemplate.getForEntity(url, TripFullOutputDTO.class);

            url = "http://trip-service/client/"+clientId;
            ResponseEntity<ClientOutputDTO> clientResponse = restTemplate.getForEntity(url,ClientOutputDTO.class);
            return new TicketOutputDTO(ticketRepository.save(new Ticket((response.getBody()),clientResponse.getBody())));
        }catch (HttpClientErrorException e){
            throw new BackErrorException(e.getResponseBodyAsString());
        }
    }

    @Override
    public TicketOutputDTO getTicket(Integer ticketId) {
        try {
        return new TicketOutputDTO(ticketRepository.findById(ticketId)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun ticket con id: "+ticketId)));
        }catch (HttpClientErrorException e){
            throw new BackErrorException(e.getResponseBodyAsString());
        }
    }
}
