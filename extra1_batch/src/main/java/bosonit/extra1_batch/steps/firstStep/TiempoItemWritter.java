package bosonit.extra1_batch.steps.firstStep;

import bosonit.extra1_batch.tiempo.Tiempo;
import bosonit.extra1_batch.tiempo.repository.TiempoRepository;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class TiempoItemWritter implements ItemWriter<Tiempo> {

    private TiempoRepository tiempoRepository;

    public TiempoItemWritter(TiempoRepository tiempoRepository) {
        this.tiempoRepository = tiempoRepository;
    }

    @Override
    public void write(List<? extends Tiempo> list) throws Exception {
        list.forEach(tiempo -> {
                tiempoRepository.save(tiempo);
        });
    }
}
