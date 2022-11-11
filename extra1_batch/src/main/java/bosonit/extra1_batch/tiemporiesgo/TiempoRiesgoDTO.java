package bosonit.extra1_batch.tiemporiesgo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiempoRiesgoDTO {
    private String location;
    private Integer yearNum;
    private Integer monthNum;
    private Integer numTemperatures;
    private Float temperatureAvg;

    public TiempoRiesgoDTO(String location, Integer year, Integer month, Long numTemperatures, Double temperatureAvg) {
        this.location = location;
        this.yearNum = year;
        this.monthNum = month;
        this.numTemperatures = (int) (long) numTemperatures;
        this.temperatureAvg = (float)(double) temperatureAvg;
    }
}
