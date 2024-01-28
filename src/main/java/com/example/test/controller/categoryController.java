package com.example.test.controller;

import com.example.test.model.Category;
import com.example.test.model.Product;
import com.example.test.repository.CategoryRepository;
import com.example.test.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class categoryController {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public categoryController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/category/{categoryId}/edit")
    public String editProduct(@PathVariable int categoryId, Model model) {
        List<Product> products = productRepository.findAll();
        Category category = categoryRepository.findById(categoryId).orElse(null);
        model.addAttribute("products", products);
        model.addAttribute("category", category);
        return "category-edit";
    }

    @PostMapping("/category/{categoryId}/update")
    public String updateCategory(Category category, Model model) {
        categoryRepository.save(category);
        return "category-update";
    }



}
