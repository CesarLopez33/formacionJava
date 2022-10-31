package bosonit.ejercicio_16_FrontBack.dtos;

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

}
