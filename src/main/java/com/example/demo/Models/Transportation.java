package com.example.demo.Models;

import com.example.demo.Enums.DrivingLicenseCategory;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "transportation")
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;
    String name;
    int numberOfPlaces;
    @OneToOne
    Driver driver;
    DrivingLicenseCategory requiredDrivingLicenseCategory;

    public Transportation(String name, int numberOfPlaces, Driver driver, DrivingLicenseCategory requiredDrivingLicenseCategory) {
        this.name = name;
        this.numberOfPlaces = numberOfPlaces;
        this.driver = driver;
        this.requiredDrivingLicenseCategory = requiredDrivingLicenseCategory;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public DrivingLicenseCategory getRequiredDrivingLicenseCategory() {
        return requiredDrivingLicenseCategory;
    }

    public void setRequiredDrivingLicenseCategory(DrivingLicenseCategory requiredDrivingLicenseCategory) {
        this.requiredDrivingLicenseCategory = requiredDrivingLicenseCategory;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "name='" + name + '\'' +
                ", numberOfPlaces=" + numberOfPlaces +
                ", driver=" + driver +
                ", requiredDrivingLicenseCategory=" + requiredDrivingLicenseCategory +
                '}';
    }
}
