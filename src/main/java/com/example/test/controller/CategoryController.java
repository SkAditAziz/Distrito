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
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @GetMapping("/showProducts")
    public String showProduct(@RequestParam int categoryId, Model model) {
        List<Product> products = categoryRepository.findProductsByCategoryId(categoryId);
        model.addAttribute("products", products);
        return "category-show-products";
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
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);

        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            existingCategory.setProducts(Stream.concat(existingCategory.getProducts().stream(), category.getProducts().stream())
                    .collect(Collectors.toList()));

            categoryRepository.save(existingCategory);
        }
        return "category-update";
    }
}
