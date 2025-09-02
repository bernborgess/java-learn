package com.example.fruehling.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fruehling.dto.UserDto;
import com.example.fruehling.entity.User;
import com.example.fruehling.service.UserService;

import lombok.AllArgsConstructor;

import static com.example.fruehling.controllers.UserController.URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = URL, produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserService service;
    public static final String URL = "/user";

    @GetMapping("/new-user")
    public ResponseEntity<String> createNewUser(@RequestParam String name) {
        service.newUser(name);
        return ResponseEntity.ok("created successfully");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        var users = service.getUsers();
        System.out.println("Hey!");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/with-computer")
    public ResponseEntity<String> associateUserWithComputer(
            @RequestParam Long userId,
            @RequestParam Long computerId) {
        service.associate(userId, computerId);
        return ResponseEntity.ok("associated successfully");
    }

    // TODO: Move to mapper
    private UserDto toDto(User user) {

        var computers = user.getComputers();
        String os = computers.size() > 0 ? computers.getFirst().getOs() : "";

        return new UserDto(
                user.getId(),
                user.getName(),
                os);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<UserDto>> filter(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String os) {
        System.out.println("Filter by os " + os);
        var users = service.filter(id, name, os);
        List<UserDto> dtos = users.stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
