package com.example.fruehling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fruehling.entity.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

    List<Computer> findAll();

}
