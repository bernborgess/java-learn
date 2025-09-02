package com.example.fruehling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.fruehling.entity.Computer;
import com.example.fruehling.entity.User;
import com.example.fruehling.repository.ComputerRepository;
import com.example.fruehling.repository.UserRepository;
import com.example.fruehling.specifications.UserSpecs;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository repository;
    @Autowired
    private final ComputerRepository computerRepository;

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

    public void associate(Long userId, Long computerId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found " + userId));
        Computer computer = computerRepository.findById(computerId)
                .orElseThrow(() -> new EntityNotFoundException("Computer not found " + computerId));

        System.out.println("user: " + user.getNome());
        System.out.println("computer : " + computer.getOs());

        user.getComputers().add(computer);

        repository.save(user);
        computerRepository.save(computer);

    }

    public void save(User user) {
        repository.save(user);
    }

    public List<User> filter(String id, String nome, String os) {
        System.out.println("Filtering on " + os);
        Specification<User> spec = Specification.unrestricted();

        if (StringUtils.hasLength(id)) {
            spec = spec.and(UserSpecs.hasId(id));
        }

        if (StringUtils.hasLength(nome)) {
            spec = spec.and(UserSpecs.containsNome(nome));
        }

        if (StringUtils.hasLength(os)) {
            spec = spec.and(UserSpecs.containsOs(os));
        }

        return repository.findAll(spec);
    }

}