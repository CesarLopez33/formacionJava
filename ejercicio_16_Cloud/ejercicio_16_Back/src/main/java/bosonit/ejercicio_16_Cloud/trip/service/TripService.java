package bosonit.ejercicio_16_Cloud.trip.service;

import bosonit.ejercicio_16_Cloud.trip.dtos.TripFullOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripInputDTO;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripOutputDTO;

import java.util.List;

public interface TripService {
    TripOutputDTO createTrip(TripInputDTO tripInput);
    TripOutputDTO updateTrip(Integer id,TripInputDTO tripInput);
    TripFullOutputDTO obtainTrip(Integer id);
    List<TripFullOutputDTO> obtainAllTrips();

    //Gestion de pasajeros
    void deleteTrip(Integer id);
    Integer countPassengers(Integer trip_id);
    TripFullOutputDTO addPassenger(Integer trip_id, Integer client_id);
    TripOutputDTO changeStatus(Integer trip_id,String status);
    String verifyStatus(Integer trip_id);
}
