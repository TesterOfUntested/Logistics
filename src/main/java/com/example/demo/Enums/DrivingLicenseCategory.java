package com.example.demo.Enums;

public enum DrivingLicenseCategory {

    B("B"),
    C("C"),
    CE("C+E");

    public final String category;

    DrivingLicenseCategory(String category) {
        this.category = category;
    }
}
