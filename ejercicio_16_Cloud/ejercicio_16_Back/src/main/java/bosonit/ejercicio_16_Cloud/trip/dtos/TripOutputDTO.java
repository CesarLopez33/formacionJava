package bosonit.ejercicio_16_Cloud.trip.dtos;

import bosonit.ejercicio_16_Cloud.trip.Trip;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TripOutputDTO {
    private Integer id;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String status;

    public TripOutputDTO(Trip t) {
        this.id = t.getTrip_id();
        this.origin = t.getOrigin();
        this.destination = t.getDestination();
        this.departureDate = t.getDepartureDate();
        this.arrivalDate = t.getDepartureDate();
        this.status = t.getStatus();
    }
}
