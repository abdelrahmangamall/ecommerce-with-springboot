package com.example.E_Commerce.controller;

import com.example.E_Commerce.model.Cart;
import com.example.E_Commerce.response.ApiResponse;
import com.example.E_Commerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @PostMapping("/add-product/{id}")
    public ResponseEntity<ApiResponse> addProduct(@PathVariable int id){
        Cart cart = cartService.addProductToCart(id);
        return ResponseEntity.ok(new ApiResponse("Success",cart));
    }
    @GetMapping
    public ResponseEntity<ApiResponse> getCart(){
        Cart cart = cartService.getCart();
        return ResponseEntity.ok(new ApiResponse("Success",cart));
    }
}
