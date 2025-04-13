package com.example.demo.Repositories;

import com.example.demo.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DriverRepository extends JpaRepository<Driver, UUID> {

    Optional<Driver> findByFirstNameAndLastName(String firstName, String lastName);

}
