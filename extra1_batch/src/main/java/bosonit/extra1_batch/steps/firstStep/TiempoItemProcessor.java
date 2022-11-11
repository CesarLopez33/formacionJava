package bosonit.extra1_batch.steps.firstStep;

import bosonit.extra1_batch.tiempo.Tiempo;
import org.springframework.batch.item.ItemProcessor;

public class TiempoItemProcessor implements ItemProcessor<Tiempo,Tiempo> {
    @Override
    public Tiempo process(Tiempo tiempo) throws Exception {
        if(tiempo.getTemperature()>50 || tiempo.getTemperature()<-20) {
            throw new IllegalArgumentException();
        }else
            return tiempo;
    }
}
