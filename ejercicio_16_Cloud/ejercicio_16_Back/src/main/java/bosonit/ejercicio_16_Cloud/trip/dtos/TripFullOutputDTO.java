package bosonit.ejercicio_16_Cloud.trip.dtos;

import bosonit.ejercicio_16_Cloud.client.dtos.ClientOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.Trip;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class TripFullOutputDTO {
    private Integer id;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
    private List<ClientOutputDTO> passengers = new ArrayList<>();

    public TripFullOutputDTO(Trip t) {
        this.id = t.getTrip_id();
        this.origin = t.getOrigin();
        this.destination = t.getDestination();
        this.departureDate = t.getDepartureDate();
        this.arrivalDate = t.getDepartureDate();
        this.status = t.getStatus();
        this.passengers=t.getPassengers().stream().map(ClientOutputDTO::new).toList();
    }
}
