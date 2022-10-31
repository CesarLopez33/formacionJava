package bosonit.ejercicio_16_Cloud.trip.controllers;

import bosonit.ejercicio_16_Cloud.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class TripDeleteController {
    @Autowired
    TripService tripService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Integer id){
        tripService.deleteTrip(id);
        return new ResponseEntity<>("Viaje eliminado con exito", HttpStatus.OK);
    }
}
