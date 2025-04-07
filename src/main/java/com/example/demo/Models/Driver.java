package com.example.demo.Models;

import com.example.demo.Enums.DrivingLicenseCategory;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;
    String firstName;
    String lastName;
    int age;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    List<DrivingLicenseCategory> drivingLicenseCategory;
    @Embedded
    Address address;

    public Driver() {
    }

    public Driver(String firstName, String lastName, int age, List<DrivingLicenseCategory> drivingLicenseCategory, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.drivingLicenseCategory = drivingLicenseCategory;
        this.address = address;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<DrivingLicenseCategory> getDrivingLicenseCategory() {
        return drivingLicenseCategory;
    }

    public void setDrivingLicenseCategory(List<DrivingLicenseCategory> drivingLicenseCategory) {
        this.drivingLicenseCategory = drivingLicenseCategory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", drivingLicenseCategory=" + drivingLicenseCategory +
                ", address=" + address +
                '}';
    }
}
