package bosonit.ejercicio_16_Cloud.client.dtos;

import bosonit.ejercicio_16_Cloud.client.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientOutputDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String telefone;

    public ClientOutputDTO(Client c) {
        this.id = c.getClient_id();
        this.name = c.getName();
        this.surname = c.getSurname();
        this.age = c.getAge();
        this.email = c.getEmail();
        this.telefone = c.getTelefone();
    }
}
