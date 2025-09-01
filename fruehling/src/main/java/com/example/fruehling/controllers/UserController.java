package com.example.fruehling.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fruehling.entity.User;

import lombok.NoArgsConstructor;

import static com.example.fruehling.controllers.UserController.URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = URL, produces = APPLICATION_JSON_VALUE)
// Temporary
@NoArgsConstructor
public class UserController {
    public static final String URL = "/user";

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        System.out.println("Hey!");
        return ResponseEntity.ok(List.of());
    }

}
