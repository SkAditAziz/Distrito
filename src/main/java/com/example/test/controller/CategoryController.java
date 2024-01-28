package com.example.test.controller;

import com.example.test.model.Category;
import com.example.test.model.Product;
import com.example.test.repository.CategoryRepository;
import com.example.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Autowired
    public CategoryController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam int categoryId, Model model) {
        List<Product> products = productRepository.findAll();
        Category category = categoryRepository.findById(categoryId).orElse(null);
        model.addAttribute("products", products);
        model.addAttribute("category", category);
        return "category-edit";
    }

    @PostMapping("/update")
    public String updateCategory(Category category, Model model) {
        categoryRepository.save(category);
        return "category-update";
    }
}
