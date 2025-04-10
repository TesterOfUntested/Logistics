package com.example.demo.Controllers;

import com.example.demo.Models.Trip;
import com.example.demo.Repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("/getAllTrips")
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @PostMapping("/createTrip")
    public Trip createTrip(@RequestBody Trip trip) {
        return tripRepository.save(trip);
    }

}
