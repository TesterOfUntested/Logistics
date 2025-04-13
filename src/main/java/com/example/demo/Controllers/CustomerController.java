package com.example.demo.Controllers;

import com.example.demo.Models.Customer;
import com.example.demo.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/getCustomerById")
    public Optional<Customer> getCustomer(@RequestParam UUID uuid) {
        return customerRepository.findById(uuid);
    }

    @GetMapping("/getCustomerByFullName")
    public Optional<Customer> getCustomer(@RequestParam String firstName, @RequestParam String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping("/createCustomer")
    public Customer createCustomer(@ModelAttribute Customer customer) {
        return customerRepository.save(customer);
    }

}
