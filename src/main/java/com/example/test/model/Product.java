package com.example.test.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Product() {
        this.id = 0;
        this.name = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
