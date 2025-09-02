package com.example.fruehling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fruehling.entity.Computer;
import com.example.fruehling.repository.ComputerRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComputerService {

    @Autowired
    private final ComputerRepository repository;

    @Transactional
    public void newComputer(String os) {
        try {
            var computer = new Computer(os);
            repository.save(computer);
        } catch (Exception e) {
            System.out.println("Error saving computer" + os + " " +
                    e.getMessage());

        }
    }

    public List<Computer> getComputers() {
        var computers = repository.findAll();
        for (var computer : computers) {
            System.out.println("#> " + computer.getOs());
        }
        return computers;
    }

}
