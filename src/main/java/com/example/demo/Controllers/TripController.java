package com.example.demo.Controllers;

import com.example.demo.Models.Trip;
import com.example.demo.Repositories.GroupRepository;
import com.example.demo.Repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/getAllTrips")
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @GetMapping("/getTripById")
    public Optional<Trip> getTripById(@RequestParam UUID uuid) {
        return tripRepository.findById(uuid);
    }

    @GetMapping("/getTotalCustomers")
    public ResponseEntity<Integer> getTotalCustomers(UUID uuid) {
        return tripRepository.findById(uuid)
                .map(trip -> trip.getGroupId().stream()
                        .map(groupRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .mapToInt(group -> group.getCustomers() != null ? group.getCustomers().size() : 0)
                        .sum())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/createTrip")
    public Trip createTrip(@RequestBody Trip trip) {
        return tripRepository.save(trip);
    }

}
