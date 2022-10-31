package bosonit.ejercicio_16_Cloud.trip.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TripInputDTO {
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String status;
}
