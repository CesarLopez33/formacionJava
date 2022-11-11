package bosonit.extra1_batch.config;

import bosonit.extra1_batch.steps.ultimateStep.TiempoRiesgoFileProcessor;
import bosonit.extra1_batch.steps.ultimateStep.TiempoRiesgoFileWritter;
import bosonit.extra1_batch.steps.secondStep.TiempoErrorItemProcessor;
import bosonit.extra1_batch.steps.secondStep.TiempoErrorItemWritter;
import bosonit.extra1_batch.steps.firstStep.TiempoItemProcessor;
import bosonit.extra1_batch.steps.firstStep.TiempoItemWritter;
import bosonit.extra1_batch.steps.thirdStep.TiempoRiesgoItemProcessor;
import bosonit.extra1_batch.steps.thirdStep.TiempoRiesgoItemWritter;
import bosonit.extra1_batch.tiempo.Tiempo;
import bosonit.extra1_batch.tiempo.TiempoOutputDTO;
import bosonit.extra1_batch.tiempo.repository.TiempoRepository;
import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgo;
import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgoDTO;
import bosonit.extra1_batch.tiemporiesgo.mapper.TiempoRiesgoDtoRowMapper;
import bosonit.extra1_batch.tiemporiesgo.mapper.TiempoRiesgoRowMapper;
import bosonit.extra1_batch.tiemporiesgo.repository.TiempoRiesgoRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class JobBatchConfiguration {

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    TiempoRepository tiempoRepository;
    @Autowired
    TiempoRiesgoRepository tiempoRiesgoRepository;
    @Autowired
    DataSource dataSource;

    @Bean
    public FlatFileItemReader<Tiempo> tiempoReader() {

        return new FlatFileItemReaderBuilder<Tiempo>()
                .name("tiempoReader")
                .resource(new ClassPathResource("data2.csv"))
                .delimited()
                .names("location", "date", "temperature")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Tiempo.class);
                }})
                .build();
    }

    @Bean
    public JdbcCursorItemReader<TiempoRiesgoDTO> tiempoRiesgoItemReader() {
        JdbcCursorItemReader<TiempoRiesgoDTO> reader = new JdbcCursorItemReader<>();
        reader.setSql("SELECT t.location,YEAR(t.date) as y,MONTH(t.date) as m,COUNT(t.temperature) as c,AVG(t.temperature) as average"
                + " FROM Tiempo AS t GROUP BY t.location,YEAR(t.date),MONTH(t.date) ORDER BY t.location");
        reader.setDataSource(dataSource);
        reader.setFetchSize(100);
        reader.setRowMapper(new TiempoRiesgoDtoRowMapper());

        return reader;
    }
    @Bean
    public JdbcCursorItemReader<TiempoRiesgo> tiempoRiesgoDatabaseItemReader() {
        JdbcCursorItemReader<TiempoRiesgo> reader = new JdbcCursorItemReader<>();
        reader.setSql("SELECT t.location,t.year_num,t.month_num,t.num_temperatures,t.temperature_avg,t.risk"
                + " FROM tiempo_riesgo AS t");
        reader.setDataSource(dataSource);
        reader.setFetchSize(100);
        reader.setRowMapper(new TiempoRiesgoRowMapper());

        return reader;
    }

    @Bean
    public Job proccesData(Step step1, Step step2, Step step3,Step step4) {
        return jobBuilderFactory.get("proccesData")
                .incrementer(new RunIdIncrementer())
                .listener(new JobListener(tiempoRiesgoRepository,tiempoRepository))
                .flow(step1)
                .next(step2)
                .next(step3)
                .next(step4)
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Tiempo, Tiempo>chunk(100)
                .faultTolerant()
                .skipLimit(100)
                .skip(IllegalArgumentException.class)
                .reader(tiempoReader())
                .processor(new TiempoItemProcessor())
                .writer(new TiempoItemWritter(tiempoRepository))
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .<Tiempo, TiempoOutputDTO>chunk(100)
                .reader(tiempoReader())
                .processor(new TiempoErrorItemProcessor())
                .writer(new TiempoErrorItemWritter())
                .build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .<TiempoRiesgoDTO, TiempoRiesgo>chunk(100)
                .reader(tiempoRiesgoItemReader())
                .processor(new TiempoRiesgoItemProcessor())
                .writer(new TiempoRiesgoItemWritter(tiempoRiesgoRepository))
                .build();
    }
    @Bean
    public Step step4() {
        return stepBuilderFactory.get("step4")
                .<TiempoRiesgo, TiempoRiesgo>chunk(100)
                .reader(tiempoRiesgoDatabaseItemReader())
                .processor(new TiempoRiesgoFileProcessor())
                .writer(new TiempoRiesgoFileWritter())
                .build();
    }
}