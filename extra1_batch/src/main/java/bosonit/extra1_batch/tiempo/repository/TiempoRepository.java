package bosonit.extra1_batch.tiempo.repository;

import bosonit.extra1_batch.tiempo.Tiempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiempoRepository extends JpaRepository<Tiempo,Integer> {
}
