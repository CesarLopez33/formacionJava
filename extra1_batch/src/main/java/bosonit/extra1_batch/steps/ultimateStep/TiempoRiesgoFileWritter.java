package bosonit.extra1_batch.steps.ultimateStep;

import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgo;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;


public class TiempoRiesgoFileWritter extends FlatFileItemWriter<TiempoRiesgo> {
    public TiempoRiesgoFileWritter(){
        setResource(new FileSystemResource("src/main/resources/out.csv"));
        setAppendAllowed(false);
        setLineAggregator(new DelimitedLineAggregator<TiempoRiesgo>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<TiempoRiesgo>() {
                    {
                        setNames(new String[]{"location", "monthNum", "yearNum","numTemperatures","temperatureAvg","risk"});
                    }
                });
            }
        });
    }
}
