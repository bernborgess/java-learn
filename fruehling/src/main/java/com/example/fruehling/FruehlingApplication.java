package com.example.fruehling;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.fruehling.entity.User;
import com.example.fruehling.service.UserService;

@SpringBootApplication
public class FruehlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruehlingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserService userService) {
        return (args) -> {
            User user1 = new User();
            user1.setNome("Peter");
            User user2 = new User();
            user2.setNome("Robert");

            userService.save(user1);
            userService.save(user2);
            // fetch all
            System.out.println("----List of Users----");
            for (var user : userService.getUsers()) {
                System.out.println("User " + user);
            }

        };
    }

}
