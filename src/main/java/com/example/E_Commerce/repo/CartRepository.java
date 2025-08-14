package com.example.E_Commerce.repo;

import com.example.E_Commerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart , Integer> {
}
