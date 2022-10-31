package bosonit.ejercicio_16_Cloud.client.repository;

import bosonit.ejercicio_16_Cloud.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
