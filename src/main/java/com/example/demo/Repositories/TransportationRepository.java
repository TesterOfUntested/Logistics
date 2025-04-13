package com.example.demo.Repositories;

import com.example.demo.Models.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransportationRepository extends JpaRepository<Transportation, UUID> {
}
