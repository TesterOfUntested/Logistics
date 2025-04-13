package com.example.demo.Repositories;

import com.example.demo.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);

}
