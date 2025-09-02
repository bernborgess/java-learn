package com.example.fruehling.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.example.fruehling.entity.User;

public class UserSpecs {

    public static Specification<User> hasId(String providedId) {
        return (root, query, cb) -> cb.equal(root.get("id"), providedId);
    }

    public static Specification<User> containsNome(String providedNome) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("nome")), "%" + providedNome.toLowerCase() + "%");
    }

    public static Specification<User> containsOs(String providedOs) {
        return (root, query, cb) -> cb.equal(root.get("computers").get("os"),
                providedOs);

    }
}
