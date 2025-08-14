package com.example.E_Commerce.controller;

import com.example.E_Commerce.model.Category;
import com.example.E_Commerce.response.ApiResponse;
import com.example.E_Commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category category) {
       Category category1 = categoryService.addCategory(category);
       return ResponseEntity.ok(new ApiResponse("Succssefully Added" , category1));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(new ApiResponse("Found!" , categoryService.getAllCategory()));
    }
}
