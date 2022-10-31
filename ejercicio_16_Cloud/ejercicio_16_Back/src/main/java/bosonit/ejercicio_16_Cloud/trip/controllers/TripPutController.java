package bosonit.ejercicio_16_Cloud.trip.controllers;

import bosonit.ejercicio_16_Cloud.trip.dtos.TripInputDTO;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TripPutController {
    @Autowired
    TripService tripService;

    @PutMapping("/{id}")
    public TripOutputDTO putTrip(@PathVariable Integer id, @RequestBody TripInputDTO trip){
        return tripService.updateTrip(id,trip);
    }

}
