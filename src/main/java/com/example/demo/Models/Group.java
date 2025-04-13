package com.example.demo.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customerGroup")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;

    @OneToMany
    List<Customer> customers;

    @Embedded
    Address address;

    @ElementCollection
    private List<UUID> tripIds = new ArrayList<>();

    public Group() {
    }

    public Group(List<Customer> customers) {
        this.customers = customers;
    }

    public Group(List<Customer> customers, Address address) {
        this.customers = customers;
        this.address = address;
    }

    public List<UUID> getTripIds() {
        return tripIds;
    }

    public void setTripIds(List<UUID> tripIds) {
        this.tripIds = tripIds;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Group{" +
                "customers=" + customers +
                ", address=" + address +
                '}';
    }
}
