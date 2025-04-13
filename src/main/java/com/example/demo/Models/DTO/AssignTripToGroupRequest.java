package com.example.demo.Models.DTO;

import java.util.UUID;

public class AssignTripToGroupRequest {
    private UUID groupId;
    private UUID tripId;

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }
}