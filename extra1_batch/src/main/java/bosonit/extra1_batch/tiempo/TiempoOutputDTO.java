package bosonit.extra1_batch.tiempo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiempoOutputDTO {
    private String location;
    private String date;
    private Integer temperature;

    public TiempoOutputDTO(Tiempo t) {
        this.location = t.getLocation();
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(t.getDate());
        this.temperature = t.getTemperature();
    }
}
