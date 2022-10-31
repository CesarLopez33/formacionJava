package bosonit.ejercicio_16_FrontBack.ticket.repository;

import bosonit.ejercicio_16_FrontBack.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
