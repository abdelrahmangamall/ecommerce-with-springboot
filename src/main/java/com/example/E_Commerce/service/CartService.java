package com.example.E_Commerce.service;

import com.example.E_Commerce.excaption.ResourceNotFound;
import com.example.E_Commerce.model.Cart;
import com.example.E_Commerce.model.Product;
import com.example.E_Commerce.model.User;
import com.example.E_Commerce.repo.CartRepository;
import com.example.E_Commerce.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public Cart addProductToCart(int product_id) {
        User user = getCurrentUser();
        if(user.getCart() == null){
            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
            user.setCart(cart);
        }
        Cart cart = user.getCart();
        cart.getProducts().add(productRepository
                .findById(product_id)
                .orElseThrow(() -> new ResourceNotFound("Product Not Found")));
        return cartRepository.save(cart);
    }
    public Cart getCart(){
        User user = getCurrentUser();
        if(user.getCart() == null){
            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
            user.setCart(cart);
        }
        return user.getCart();
    }
    private User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
