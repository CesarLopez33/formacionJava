package bosonit.ejercicio_16_FrontBack.ticket.dtos;

import bosonit.ejercicio_16_FrontBack.ticket.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TicketOutputDTO {
    private Integer id;
    private Integer passengerId;
    private String passengerName;
    private String passengerLastName;
    private String passengerEmail;
    private String tripOrigin;
    private String tripDestination;
    private Date departureDate;
    private Date arrivalDate;


    public TicketOutputDTO(Ticket t) {
        this.id = t.getId();
        this.passengerId = t.getPassengerId();
        this.passengerName = t.getPassengerName();
        this.passengerLastName = t.getPassengerLastName();
        this.passengerEmail = t.getPassengerEmail();
        this.tripOrigin = t.getTripOrigin();
        this.tripDestination = t.getTripDestination();
        this.departureDate = t.getDepartureDate();
        this.arrivalDate = t.getArrivalDate();
    }
}
