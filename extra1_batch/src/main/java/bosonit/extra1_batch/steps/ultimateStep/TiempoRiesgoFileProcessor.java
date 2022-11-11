package bosonit.extra1_batch.steps.ultimateStep;

import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgo;
import org.springframework.batch.item.ItemProcessor;

public class TiempoRiesgoFileProcessor implements ItemProcessor<TiempoRiesgo, TiempoRiesgo> {
    @Override
    public TiempoRiesgo process(TiempoRiesgo tiempoRiesgo) throws Exception {
        return tiempoRiesgo;
    }
}
