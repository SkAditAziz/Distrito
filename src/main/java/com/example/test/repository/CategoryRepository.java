package com.example.test.repository;

import com.example.test.model.Category;
import com.example.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c.products FROM Category c WHERE c.id = :categoryId")
    List<Product> findProductsByCategoryId(int categoryId);
}
