package bosonit.ejercicio_16_Cloud.client;

import bosonit.ejercicio_16_Cloud.client.dtos.ClientInputDTO;
import bosonit.ejercicio_16_Cloud.trip.Trip;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @SequenceGenerator(name="ClientSequence")
    @GeneratedValue(generator = "ClientSequence")
    private Integer client_id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer age;
    @Column
    private String email;
    @Column
    private String telefone;

    @ManyToMany(mappedBy = "passengers", fetch = FetchType.LAZY)
    @JsonBackReference
    List<Trip> trips = new ArrayList<>();

    public Client(ClientInputDTO c) {
        this.name = c.getName();
        this.surname = c.getSurname();
        this.age = c.getAge();
        this.email = c.getEmail();
        this.telefone = c.getTelefone();
    }
}
