package com.example.demo.Controllers;

import com.example.demo.Models.Customer;
import com.example.demo.Models.DTO.AssignTripToGroupRequest;
import com.example.demo.Models.Group;
import com.example.demo.Models.Trip;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.GroupRepository;
import com.example.demo.Repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("/getAllGroups")
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/getGroupById")
    public Optional<Group> getGroupById(UUID uuid) {
        return groupRepository.findById(uuid);
    }

    @PostMapping("/addToGroup")
    public Group addToGroup(@RequestParam UUID customerId, @RequestParam UUID groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        Optional<Customer> customer = customerRepository.findById(groupId);
        group.get().addCustomer(customer.get());
        return groupRepository.save(group.get());
    }

    @PostMapping("/assignTrip")
    public ResponseEntity<String> assignTripToGroup(@RequestBody AssignTripToGroupRequest request) {
        Optional<Group> groupOpt = groupRepository.findById(request.getGroupId());
        Optional<Trip> tripOpt = tripRepository.findById(request.getTripId());

        if (groupOpt.isEmpty() || tripOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono grupy lub wycieczki.");
        }

        Group group = groupOpt.get();
        Trip trip = tripOpt.get();

        if (group.getTripIds() == null) {
            group.setTripIds(new ArrayList<>());
        }
        if (!group.getTripIds().contains(request.getTripId())) {
            group.getTripIds().add(request.getTripId());
            groupRepository.save(group);
        }

        if (trip.getGroupId() == null) {
            trip.setGroupId(new ArrayList<>());
        }
        if (!trip.getGroupId().contains(request.getGroupId())) {
            trip.getGroupId().add(request.getGroupId());
            tripRepository.save(trip);
        }

        return ResponseEntity.ok("Wycieczka przypisana do grupy.");
    }

    @PostMapping("/createGroup")
    public Group createGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }
}
