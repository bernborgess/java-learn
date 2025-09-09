package com.example.fruehling.controllers.pc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fruehling.entity.Computer;
import com.example.fruehling.service.ComputerService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.fruehling.controllers.pc.ComputerController.URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = URL, produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ComputerController {
    @Autowired
    private final ComputerService service;
    public static final String URL = "/computer";

    @GetMapping("/new-computer")
    public ResponseEntity<String> createNewComputer(@RequestParam String os) {
        service.newComputer(os);
        return ResponseEntity.ok("create new computer for you");
    }

    @GetMapping
    public ResponseEntity<List<Computer>> getAll() {
        var computers = service.getComputers();
        System.out.println("got all pcs");
        return ResponseEntity.ok(computers);
    }

}
