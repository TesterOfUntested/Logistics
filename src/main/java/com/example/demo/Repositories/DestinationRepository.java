package com.example.demo.Repositories;

import com.example.demo.Models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DestinationRepository extends JpaRepository<Destination, UUID> {
}
