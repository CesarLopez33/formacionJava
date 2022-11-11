package bosonit.extra1_batch.steps.thirdStep;

import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgo;
import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgoDTO;
import org.springframework.batch.item.ItemProcessor;

public class TiempoRiesgoItemProcessor implements ItemProcessor<TiempoRiesgoDTO, TiempoRiesgo> {
    @Override
    public TiempoRiesgo process(TiempoRiesgoDTO t) throws Exception {
        TiempoRiesgo tiempo = new TiempoRiesgo();
        tiempo.setYearNum(t.getYearNum());
        tiempo.setMonthNum(t.getMonthNum());
        tiempo.setLocation(t.getLocation());
        tiempo.setNumTemperatures(t.getNumTemperatures());
        tiempo.setTemperatureAvg(t.getTemperatureAvg());
        if(t.getTemperatureAvg()>=36)
            tiempo.setRisk("HIGH");
        else if (t.getTemperatureAvg()<36 && t.getTemperatureAvg()>32)
            tiempo.setRisk("MEDIUM");
        else
            tiempo.setRisk("LOW");
        return tiempo;
    }
}
