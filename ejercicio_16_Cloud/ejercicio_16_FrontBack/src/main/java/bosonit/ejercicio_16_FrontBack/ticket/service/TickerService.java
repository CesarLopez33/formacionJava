package bosonit.ejercicio_16_FrontBack.ticket.service;

import bosonit.ejercicio_16_FrontBack.ticket.dtos.TicketOutputDTO;

import java.net.URISyntaxException;

public interface TickerService {
    public TicketOutputDTO generateTicket(Integer clientId,Integer tripId) throws URISyntaxException;
    public TicketOutputDTO getTicket(Integer ticketId);
}
