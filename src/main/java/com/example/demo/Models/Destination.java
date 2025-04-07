package com.example.demo.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;
    String name;
    @Embedded
    Address address;
    LocalDate date;
    LocalTime timeOfDeparture;

    public Destination(String name, Address address, LocalDate date, LocalTime timeOfDeparture) {
        this.name = name;
        this.address = address;
        this.date = date;
        this.timeOfDeparture = timeOfDeparture;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", date=" + date +
                ", timeOfDeparture=" + timeOfDeparture +
                '}';
    }
}
