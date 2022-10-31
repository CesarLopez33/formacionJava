package bosonit.ejercicio_16_Cloud.trip.controllers;

import bosonit.ejercicio_16_Cloud.trip.dtos.TripFullOutputDTO;
import bosonit.ejercicio_16_Cloud.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripGetController {
    @Autowired
    TripService tripService;

    @GetMapping("/{id}")
    public TripFullOutputDTO getTrip(@PathVariable Integer id){
        return tripService.obtainTrip(id);
    }
    @GetMapping("/all")
    public List<TripFullOutputDTO> getAllTrips (){
        return  tripService.obtainAllTrips();
    }
}
