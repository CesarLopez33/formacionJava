package bosonit.ejercicio_16_Cloud.trip;

import bosonit.ejercicio_16_Cloud.client.Client;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripInputDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Trip {
    @Id
    @SequenceGenerator(name="TripSequence")
    @GeneratedValue(generator = "TripSequence")
    private Integer trip_id;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    @JoinTable(
            name = "rel_client_trip",
            joinColumns = @JoinColumn(name = "fk_trip", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_client", nullable = false),
            uniqueConstraints = @UniqueConstraint(columnNames={"fk_trip", "fk_client"})
    )
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    @JsonManagedReference
    private List<Client> passengers = new ArrayList<>();
    private String status;

    public Trip(TripInputDTO t) {
        this.origin = t.getOrigin();
        this.destination = t.getDestination();
        this.departureDate = t.getDepartureDate();
        this.arrivalDate = t.getArrivalDate();
        this.status = t.getStatus();
    }
}
