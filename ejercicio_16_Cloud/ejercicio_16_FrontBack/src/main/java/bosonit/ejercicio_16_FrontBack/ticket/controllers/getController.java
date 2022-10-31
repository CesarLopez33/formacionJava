package bosonit.ejercicio_16_FrontBack.ticket.controllers;

import bosonit.ejercicio_16_FrontBack.ticket.dtos.TicketOutputDTO;
import bosonit.ejercicio_16_FrontBack.ticket.service.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class getController {
    @Autowired
    TickerService tickerService;

    @GetMapping("generateTicket/{clientId}/{tripId}")
    public TicketOutputDTO generateTicket(@PathVariable Integer clientId, @PathVariable Integer tripId) throws URISyntaxException {
        return tickerService.generateTicket(clientId,tripId);
    }

    @GetMapping("ticket/{ticketId}")
    public TicketOutputDTO generateTicket(@PathVariable Integer ticketId) throws URISyntaxException {
        return tickerService.getTicket(ticketId);
    }
}
