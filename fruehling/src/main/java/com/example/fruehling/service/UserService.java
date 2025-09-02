package com.example.fruehling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fruehling.entity.User;
import com.example.fruehling.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository repository;

    @Transactional
    public void newUser(String name) {
        try {
            var user = new User(name);
            repository.save(user);
        } catch (Exception e) {
            System.out.println("Erro ao tentar salver usuario " + name + " " +
                    e.getMessage());
        }
    }

    public List<User> getUsers() {
        var users = repository.findAll();
        for (var user : users) {
            System.out.println("> " + user.getNome());
        }
        return users;
    }

}