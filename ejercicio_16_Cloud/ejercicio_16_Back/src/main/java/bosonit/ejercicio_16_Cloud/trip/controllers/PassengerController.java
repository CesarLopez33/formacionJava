package bosonit.ejercicio_16_Cloud.trip.controllers;

import bosonit.ejercicio_16_Cloud.trip.dtos.TripFullOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerController {
    @Autowired
    TripService tripService;

    @GetMapping("/trip/addPassenger/{trip_id}/{client_id}")
    public TripFullOutputDTO addPassenger(@PathVariable Integer trip_id, @PathVariable Integer client_id){
        return  tripService.addPassenger(trip_id,client_id);
    }
    @GetMapping("/passenger/count/{id}")
    public ResponseEntity<String> countPassengers(@PathVariable Integer id){
        return new ResponseEntity<>("Numero de pasajeros del viaje con id " + id
                + ": " + tripService.countPassengers(id), HttpStatus.OK);
    }

    @GetMapping("/trip/verify/{id}")
    public ResponseEntity<String> verifyStatus(@PathVariable Integer id){
        return new ResponseEntity<>("Status de viaje con id "+id + ": "+tripService.verifyStatus(id),
                HttpStatus.OK);
    }

    @GetMapping("/trip/{trip_id}/{status}")
    public TripOutputDTO changeStatus(@PathVariable Integer trip_id, @PathVariable String status){
        return tripService.changeStatus(trip_id,status);
    }
}
