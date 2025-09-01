package com.example.fruehling.entity;

import jakarta.persistence.*;

@Entity
public class Computer {
    @Id
    private Long id;

    String os; // "Linux" | "Windows" | "MacOS"
}
