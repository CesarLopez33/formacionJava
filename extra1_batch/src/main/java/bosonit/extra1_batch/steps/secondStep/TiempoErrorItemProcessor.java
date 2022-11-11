package bosonit.extra1_batch.steps.secondStep;

import bosonit.extra1_batch.tiempo.Tiempo;
import bosonit.extra1_batch.tiempo.TiempoOutputDTO;
import org.springframework.batch.item.ItemProcessor;

public class TiempoErrorItemProcessor implements ItemProcessor<Tiempo, TiempoOutputDTO> {
    @Override
    public TiempoOutputDTO process(Tiempo tiempo) throws Exception {
        if(tiempo.getTemperature()>50 || tiempo.getTemperature()<-20) {
            return new TiempoOutputDTO(tiempo);
        }else
            return null;
    }
}
