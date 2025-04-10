package com.example.demo.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private UUID destinationId;

    @ElementCollection
    private List<UUID> groupId = new ArrayList<>();

    private UUID transportationId;

    public Trip() {
    }

    public Trip(UUID destinationId, List<UUID> groupId, UUID transportationId) {
        this.destinationId = destinationId;
        this.groupId = groupId;
        this.transportationId = transportationId;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "uuid=" + uuid +
                ", destinationId=" + destinationId +
                ", groupId=" + groupId +
                ", transportationId=" + transportationId +
                '}';
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(UUID destinationId) {
        this.destinationId = destinationId;
    }

    public List<UUID> getGroupId() {
        return groupId;
    }

    public void setGroupId(List<UUID> groupId) {
        this.groupId = groupId;
    }

    public UUID getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(UUID transportationId) {
        this.transportationId = transportationId;
    }
}
