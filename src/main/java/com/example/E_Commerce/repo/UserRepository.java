package com.example.E_Commerce.repo;

import com.example.E_Commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Integer> {
    Optional<User> findByUsername(String username);
}
