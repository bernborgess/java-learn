package com.example.fruehling.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private Long id;

    String nome;

    @OneToMany
    private List<Computer> computers;
}
