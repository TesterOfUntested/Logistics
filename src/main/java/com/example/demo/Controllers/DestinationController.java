package com.example.demo.Controllers;

import com.example.demo.Models.Destination;
import com.example.demo.Repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    private DestinationRepository destinationRepository;

    @GetMapping("/getAllDestinations")
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @GetMapping("/getDestinationById")
    public Optional<Destination> getDestinationById(@RequestParam UUID uuid) {
        return destinationRepository.findById(uuid);
    }

    @GetMapping("/getDestinationByName")
    public Optional<Destination> getDestinationByName(@RequestParam String name) {
        return destinationRepository.findByName(name);
    }

    @PostMapping("/createDestination")
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationRepository.save(destination);
    }
}
