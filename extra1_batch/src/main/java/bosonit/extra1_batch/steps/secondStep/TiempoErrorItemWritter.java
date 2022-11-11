package bosonit.extra1_batch.steps.secondStep;

import bosonit.extra1_batch.tiempo.Tiempo;
import bosonit.extra1_batch.tiempo.TiempoOutputDTO;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

public class TiempoErrorItemWritter extends FlatFileItemWriter<TiempoOutputDTO> {

    public TiempoErrorItemWritter(){
        setResource(new FileSystemResource("src/main/resources/errors.csv"));
        setAppendAllowed(false);
        setLineAggregator(new DelimitedLineAggregator<TiempoOutputDTO>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<TiempoOutputDTO>() {
                    {
                        setNames(new String[]{"location", "date", "temperature"});
                    }
                });
            }
        });
    }
}
