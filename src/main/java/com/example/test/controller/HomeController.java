package com.example.test.controller;

import com.example.test.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {
    private CategoryRepository categoryRepository;
    @Autowired
    public HomeController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String showIndexPage(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }
}
