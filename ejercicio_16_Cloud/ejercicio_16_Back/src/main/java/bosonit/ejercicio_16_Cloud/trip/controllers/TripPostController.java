package bosonit.ejercicio_16_Cloud.trip.controllers;

import bosonit.ejercicio_16_Cloud.trip.dtos.TripInputDTO;
import bosonit.ejercicio_16_Cloud.trip.dtos.TripOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class TripPostController {
    @Autowired
    TripService tripService;

    @PostMapping
    public TripOutputDTO postTrip(@RequestBody TripInputDTO trip){
        return tripService.createTrip(trip);
    }
}
