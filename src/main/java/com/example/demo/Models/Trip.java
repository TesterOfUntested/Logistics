package com.example.demo.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;
    @OneToOne
    Destination destination;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    List<Group> groups;
    @OneToOne
    Transportation transportation;
    @OneToOne
    Driver driver;

    public Trip(Destination destination, List<Group> groups, Transportation transportation, Driver driver) {
        this.destination = destination;
        this.groups = groups;
        this.transportation = transportation;
        this.driver = driver;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "destination=" + destination +
                ", groups=" + groups +
                ", transportation=" + transportation +
                ", driver=" + driver +
                '}';
    }
}
