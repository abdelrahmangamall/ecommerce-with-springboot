package com.example.E_Commerce.service;

import com.example.E_Commerce.model.Category;
import com.example.E_Commerce.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category){
        category.setProducts(new ArrayList<>());
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
