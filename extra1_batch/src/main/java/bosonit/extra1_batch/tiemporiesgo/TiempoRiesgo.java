package bosonit.extra1_batch.tiemporiesgo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
public class TiempoRiesgo {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String location;
    @Column
    private Integer yearNum;
    @Column
    private Integer monthNum;
    @Column
    private Integer numTemperatures;
    @Column
    private Float temperatureAvg;
    @Column
    private String risk;

}
