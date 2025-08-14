package com.example.E_Commerce.repo;

import com.example.E_Commerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category , Integer> {
    Optional<Category> findByName(String name);
}
