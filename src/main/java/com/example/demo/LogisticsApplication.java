package com.example.demo;

import com.example.demo.Enums.DrivingLicenseCategory;
import com.example.demo.Models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LogisticsApplication {

    public static void main(String[] args) {

        SpringApplication.run(LogisticsApplication.class, args);

        Customer customer = new Customer("Janusz", "Mojżesz", 21);
        Customer customer2 = new Customer("Agnieszka", "Mojżesz", 20);
        Customer customer3 = new Customer("Florian", "Mojżesz", 8);

        Address groupAddress = new Address("Kraków", "Floriańska", "12", "1", "00-001");
        Group group = new Group(Arrays.asList(customer, customer2, customer3), groupAddress);

        Address destinationAddress = new Address("Zakopane", "Krupówki", "1", "00-000");
        Destination destination = new Destination("Zakopane trip", destinationAddress, LocalDate.now().plusDays(10), LocalTime.of(9, 30));

        Address driverAddress = new Address("Kraków", "Floriańska", "12", "1", "00-001");
        Driver driver = new Driver("Jan", "Mazur", 23, List.of(DrivingLicenseCategory.B), driverAddress);

        Transportation transportation = new Transportation("Mercedes", 6, driver.getUuid(), DrivingLicenseCategory.B);

        Trip trip = new Trip(destination.getUuid(), List.of(group.getUuid()), transportation.getUuid());
        System.out.println(trip);
    }

}
