package com.example.fruehling.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "DEMO_USER")
public class User {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;

    public User(String nome) {
        this.id = 1L;
        this.nome = nome;
        this.computers = List.of();
    }

    @OneToMany
    private List<Computer> computers;
}
