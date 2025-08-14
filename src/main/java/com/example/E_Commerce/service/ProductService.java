package com.example.E_Commerce.service;

import com.example.E_Commerce.dto.ProductDto;
import com.example.E_Commerce.excaption.ResourceNotFound;
import com.example.E_Commerce.model.Category;
import com.example.E_Commerce.model.Product;
import com.example.E_Commerce.repo.CategoryRepository;
import com.example.E_Commerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product addProduct(ProductDto productDto) {
        Category category = categoryRepository.findByName(productDto.getCategory_name())
                .orElseThrow(() -> new ResourceNotFound("Category Not Found"));
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

}