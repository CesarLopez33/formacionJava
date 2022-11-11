package bosonit.extra1_batch.steps.thirdStep;

import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgo;
import bosonit.extra1_batch.tiemporiesgo.repository.TiempoRiesgoRepository;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class TiempoRiesgoItemWritter implements ItemWriter<TiempoRiesgo> {

    private TiempoRiesgoRepository tiempoRiesgoRepository;

    public TiempoRiesgoItemWritter(TiempoRiesgoRepository tiempoRiesgoRepository){
        this.tiempoRiesgoRepository=tiempoRiesgoRepository;
    }
    @Override
    public void write(List<? extends TiempoRiesgo> list) throws Exception {
        list.forEach(element->tiempoRiesgoRepository.save(element));
    }
}
