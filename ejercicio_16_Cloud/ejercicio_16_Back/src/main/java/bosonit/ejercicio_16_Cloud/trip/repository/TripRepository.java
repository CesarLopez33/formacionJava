package bosonit.ejercicio_16_Cloud.trip.repository;

import bosonit.ejercicio_16_Cloud.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Integer> {
}
