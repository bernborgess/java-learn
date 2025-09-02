package com.example.fruehling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.fruehling.dto.UserDto;
import com.example.fruehling.entity.Computer;
import com.example.fruehling.entity.User;
import com.example.fruehling.repository.ComputerRepository;
import com.example.fruehling.repository.UserRepository;
import com.example.fruehling.specifications.UserSpecs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository repository;
    @Autowired
    private final ComputerRepository computerRepository;
    @Autowired
    private final EntityManager entityManager;

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
            System.out.println("> " + user.getName());
        }
        return users;
    }

    public void associate(Long userId, Long computerId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found " + userId));
        Computer computer = computerRepository.findById(computerId)
                .orElseThrow(() -> new EntityNotFoundException("Computer not found " + computerId));

        System.out.println("user: " + user.getName());
        System.out.println("computer : " + computer.getOs());

        user.getComputers().add(computer);

        repository.save(user);
        computerRepository.save(computer);

    }

    public void save(User user) {
        repository.save(user);
    }

    public List<User> filter(String id, String name, String os) {
        System.out.println("Filtering on " + os);
        Specification<User> spec = Specification.unrestricted();

        if (StringUtils.hasLength(id)) {
            spec = spec.and(UserSpecs.hasId(id));
        }

        if (StringUtils.hasLength(name)) {
            spec = spec.and(UserSpecs.containsName(name));
        }

        if (StringUtils.hasLength(os)) {
            spec = spec.and(UserSpecs.containsOs(os));
        }

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDto> query = cb.createQuery(UserDto.class);
        Root<User> root = query.from(User.class);

        // Apply Predicate from Specification
        var pred = spec.toPredicate(root, query, cb);
        if (pred != null)
            query.where(pred);

        Join<User, Computer> computerJoin = root.join("computers", JoinType.LEFT);

        cb.currentTime();

        // Project to DTO
        query.select(cb.construct(UserDto.class,
                // Args
                root.get("id"),
                cb.concat(root.get("name"), "$"),
                computerJoin.get("os")));

        return repository.findAll(spec);
    }

}