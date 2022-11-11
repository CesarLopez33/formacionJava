package bosonit.extra1_batch.config;

import bosonit.extra1_batch.tiempo.repository.TiempoRepository;
import bosonit.extra1_batch.tiemporiesgo.repository.TiempoRiesgoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;

@Slf4j
public class JobListener implements org.springframework.batch.core.JobExecutionListener {
    TiempoRiesgoRepository tiempoRiesgoRepository;
    TiempoRepository tiempoRepository;
    JobListener(TiempoRiesgoRepository tiempoRiesgoRepository,TiempoRepository tiempoRepository){
        this.tiempoRiesgoRepository=tiempoRiesgoRepository;
        this.tiempoRepository=tiempoRepository;
    }
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Iniciando job");
        log.info("Borrando la tabla TiempoRiesgo de la base de datos");
        tiempoRiesgoRepository.deleteAll();
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus().isUnsuccessful()){
            log.error("Error ejecutando el job");
            jobExecution.getAllFailureExceptions().forEach(e->log.error(e.getMessage()));
            log.error("Borrando la tabla Tiempo de la base de datos");
            tiempoRepository.deleteAll();
        }else{
            log.info("Finalizando job -> Ejecución exitosa");
        }
    }
}
