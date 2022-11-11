package bosonit.extra1_batch.tiemporiesgo.repository;

import bosonit.extra1_batch.tiemporiesgo.TiempoRiesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiempoRiesgoRepository extends JpaRepository<TiempoRiesgo,Integer> {
}
