package bosonit.ejercicio_16_FrontBack.ticket;

import bosonit.ejercicio_16_FrontBack.dtos.ClientOutputDTO;
import bosonit.ejercicio_16_FrontBack.dtos.TripFullOutputDTO;
import bosonit.ejercicio_16_FrontBack.dtos.TripOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer passengerId;
    private String passengerName;
    private String passengerLastName;
    private String passengerEmail;
    private String tripOrigin;
    private String tripDestination;
    private Date departureDate;
    private Date arrivalDate;

    /*public Ticket(ClientOutputDTO c, TripOutputDTO t) {
        this.passengerId = c.getId();
        this.passengerName = c.getName();
        this.passengerLastName = c.getSurname();
        this.passengerEmail = c.getEmail();
        this.tripOrigin = t.getOrigin();
        this.tripDestination = t.getDestination();
        this.departureDate = t.getDepartureDate();
        this.arrivalDate = t.getArrivalDate();
    }*/

    public Ticket(TripFullOutputDTO t,ClientOutputDTO c) {
        this.passengerId = c.getId();
        this.passengerName = c.getName();
        this.passengerLastName = c.getSurname();
        this.passengerEmail = c.getEmail();
        this.tripOrigin = t.getOrigin();
        this.tripDestination = t.getDestination();
        this.departureDate = t.getDepartureDate();
        this.arrivalDate = t.getArrivalDate();
    }
}
