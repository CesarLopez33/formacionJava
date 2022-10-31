package bosonit.ejercicio_16_Cloud.client.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClientInputDTO {
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String telefone;
}
