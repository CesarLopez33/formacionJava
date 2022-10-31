package bosonit.ejercicio_16_FrontBack.dtos;

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

}
