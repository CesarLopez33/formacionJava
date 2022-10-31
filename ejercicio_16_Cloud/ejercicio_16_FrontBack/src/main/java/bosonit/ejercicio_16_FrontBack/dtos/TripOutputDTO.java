package bosonit.ejercicio_16_FrontBack.dtos;

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

}
