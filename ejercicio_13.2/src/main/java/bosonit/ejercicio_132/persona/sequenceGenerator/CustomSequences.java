package bosonit.ejercicio_132.persona.sequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class CustomSequences {
    @Id
    private String id;
    private int seq;

}
