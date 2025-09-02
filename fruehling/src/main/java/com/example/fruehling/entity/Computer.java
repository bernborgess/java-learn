package com.example.fruehling.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String os; // "Linux" | "Windows" | "MacOS"

    public Computer(String os) {
        this.id = 1L;
        this.os = os;
    }

}
