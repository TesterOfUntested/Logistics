package com.example.demo.Controllers;

import com.example.demo.Models.Transportation;
import com.example.demo.Repositories.TransportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/transportation")
public class TransportationController {

    @Autowired
    private TransportationRepository transportationRepository;

    @GetMapping("/getAllTransportations")
    public List<Transportation> getAllTransportations() {
        return transportationRepository.findAll();
    }

    @GetMapping("/getTransportationById")
    public Optional<Transportation> getTransportationById(@RequestParam UUID uuid) {
        return transportationRepository.findById(uuid);
    }

    @PostMapping("/createTransportation")
    public Transportation createTransportation(@ModelAttribute Transportation transportation) {
        return transportationRepository.save(transportation);
    }
}
