package com.example.demo.Utils;

import com.example.demo.Enums.DrivingLicenseCategory;
import com.example.demo.Models.*;
import com.example.demo.Repositories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final boolean initDb;
    private final CustomerRepository customerRepo;
    private final DriverRepository driverRepo;
    private final DestinationRepository destinationRepo;
    private final GroupRepository groupRepo;
    private final TransportationRepository transportationRepo;
    private final TripRepository tripRepo;

    public DataInitializer(@Value("${app.db.init:true}") boolean initDb,
                           CustomerRepository customerRepo,
                           DriverRepository driverRepo,
                           DestinationRepository destinationRepo,
                           GroupRepository groupRepo,
                           TransportationRepository transportationRepo,
                           TripRepository tripRepo) {
        this.initDb = initDb;
        this.customerRepo = customerRepo;
        this.driverRepo = driverRepo;
        this.destinationRepo = destinationRepo;
        this.groupRepo = groupRepo;
        this.transportationRepo = transportationRepo;
        this.tripRepo = tripRepo;
    }

    @PostConstruct
    public void initDatabase() {
        if (!initDb) {
            System.out.println("Database init is disabled.");
            return;
        }

        Customer jan = customerRepo.save(new Customer("Jan", "Kowalski", 35));
        Customer anna = customerRepo.save(new Customer("Anna", "Nowak", 28));

        Driver driver = driverRepo.save(new Driver(
                "Marcin", "Dąbrowski", 45,
                List.of(DrivingLicenseCategory.B, DrivingLicenseCategory.D),
                new Address("Bytom", "Dworcowa", "12", "41-902")
        ));

        Destination destination = destinationRepo.save(new Destination(
                "Zamek Czocha",
                new Address("Leśna", "Zamkowa", "1", "59-820"),
                LocalDate.of(2025, 5, 10),
                LocalTime.of(8, 30)
        ));

        Transportation transport = transportationRepo.save(new Transportation(
                "Renault Trafic", 8, driver.getUuid(), DrivingLicenseCategory.B
        ));

        Group group = new Group(
                List.of(jan, anna),
                new Address("Bytom", "Rynek", "5", "41-902")
        );
        group.setTripIds(new ArrayList<>());
        group = groupRepo.save(group);

        Trip trip = new Trip(destination.getUuid(), new ArrayList<>(), transport.getUuid());
        trip.setGroupId(new ArrayList<>());
        trip = tripRepo.save(trip);

        group.getTripIds().add(trip.getUuid());
        trip.getGroupId().add(group.getUuid());

        groupRepo.save(group);
        tripRepo.save(trip);

        System.out.println("Database initialized with demo data.");
    }

}