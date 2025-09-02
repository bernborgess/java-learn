package com.example.fruehling.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fruehling.entity.User;
import com.example.fruehling.service.UserService;

import lombok.AllArgsConstructor;

import static com.example.fruehling.controllers.UserController.URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

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

}
