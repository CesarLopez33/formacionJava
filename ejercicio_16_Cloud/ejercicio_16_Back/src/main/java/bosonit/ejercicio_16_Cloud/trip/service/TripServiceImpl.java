package bosonit.ejercicio_16_Cloud.trip.service;

import bosonit.ejercicio_16_Cloud.client.repository.ClientRepository;
import bosonit.ejercicio_16_Cloud.exceptions.UnprocessableEntityException;
import bosonit.ejercicio_16_Cloud.trip.Trip;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripFullOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripInputDTO;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TripServiceImpl implements TripService{
    @Autowired
    TripRepository tripRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public TripOutputDTO createTrip(TripInputDTO tripInput) {
        if(tripInput.getOrigin()==null) throw new UnprocessableEntityException("El origen no puede ser nulo");
        if(tripInput.getDestination()==null) throw new UnprocessableEntityException("El destino no puede ser nulo");
        if(tripInput.getDepartureDate()==null) throw new UnprocessableEntityException("La fecha de salida no puede ser nula");
        if(tripInput.getArrivalDate()==null) throw new UnprocessableEntityException("La fecha de llegada no puede ser nula");
        if(tripInput.getStatus()==null) throw new UnprocessableEntityException("El estatus no puede ser nulo");
        return new TripOutputDTO(tripRepository.save(new Trip(tripInput)));
    }

    @Override
    public TripOutputDTO updateTrip(Integer id, TripInputDTO tripInput) {
        Trip t = tripRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun viaje con id: " + id));
        if(tripInput.getOrigin()!=null) t.setOrigin(tripInput.getOrigin());
        if(tripInput.getDestination()!=null) t.setDestination(tripInput.getDestination());
        if(tripInput.getDepartureDate()!=null) t.setDepartureDate(tripInput.getDepartureDate());
        if(tripInput.getArrivalDate()!=null) t.setArrivalDate(tripInput.getArrivalDate());
        if(tripInput.getStatus()!=null) t.setStatus(tripInput.getStatus());
        return new TripOutputDTO(tripRepository.save(t));
    }

    @Override
    public TripFullOutputDTO obtainTrip(Integer id) {
        return new TripFullOutputDTO(tripRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun viaje con id: " + id)));
    }

    @Override
    public List<TripFullOutputDTO> obtainAllTrips() {
        return tripRepository.findAll().stream().map(TripFullOutputDTO::new).toList();
    }

    @Override
    public void deleteTrip(Integer id) {
        try {
            tripRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("No hay ningun viaje con id: " + id);
        }
    }

    @Override
    public Integer countPassengers(Integer trip_id) {
        Trip t = tripRepository.findById(trip_id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun viaje con id: " + trip_id));
        return t.getPassengers().size();
    }

    @Override
    public TripFullOutputDTO addPassenger(Integer trip_id, Integer client_id) {
        Trip t = tripRepository.findById(trip_id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun viaje con id: " + trip_id));
        if(t.getPassengers().size() == 40)
            throw new UnprocessableEntityException("El viaje tiene el numero maximo de pasajeros");
        if(t.getPassengers().stream().filter(c->c.getClient_id()==client_id).toList().size()==1)
            throw new UnprocessableEntityException("El pasajero ya esta registrado para ese viaje");
        t.getPassengers().add(clientRepository.findById(client_id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun cliente con id: "+client_id)));
        return new TripFullOutputDTO(tripRepository.save(t));
    }

    @Override
    public TripOutputDTO changeStatus(Integer trip_id, String status) {
        Trip t = tripRepository.findById(trip_id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun viaje con id: " + trip_id));
        t.setStatus(status);
        return new TripOutputDTO(tripRepository.save(t));
    }

    @Override
    public String verifyStatus(Integer trip_id) {
        return tripRepository.findById(trip_id)
                .orElseThrow(()->new EntityNotFoundException("No hay ningun viaje con id: " + trip_id))
                .getStatus();
    }
}
