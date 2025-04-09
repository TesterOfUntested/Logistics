package com.example.demo.Controllers;

import com.example.demo.Models.Customer;
import com.example.demo.Models.Group;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createGroup")
    public Group createGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }
}
