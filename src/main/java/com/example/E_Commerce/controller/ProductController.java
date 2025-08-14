package com.example.E_Commerce.controller;

import com.example.E_Commerce.dto.ProductDto;
import com.example.E_Commerce.model.Product;
import com.example.E_Commerce.response.ApiResponse;
import com.example.E_Commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto product) {
        Product product1 = productService.addProduct(product);
        return ResponseEntity.ok(new ApiResponse("Successfully Added" , product1));

    }

    @GetMapping
    public  ResponseEntity<ApiResponse> getAll() {

        return ResponseEntity.ok(new ApiResponse("Found!" , productService.getAllProduct()));

    }


}
