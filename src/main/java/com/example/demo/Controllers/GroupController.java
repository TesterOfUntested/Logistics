package com.example.demo.Controllers;

import com.example.demo.Models.Group;
import com.example.demo.Repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }
}
