package com.example.demo.Controllers;

import com.example.demo.Models.Driver;
import com.example.demo.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/getAllDrivers")
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @GetMapping("/getDriverById")
    public Optional<Driver> getDriverById(UUID uuid) {
        return driverRepository.findById(uuid);
    }

    @GetMapping("/getDriverByFullName")
    public Optional<Driver> getDriverByFullName(String firstName, String lastName) {
        return driverRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping
    public Driver createDriver(@ModelAttribute Driver driver) {
        return driverRepository.save(driver);
    }

}
