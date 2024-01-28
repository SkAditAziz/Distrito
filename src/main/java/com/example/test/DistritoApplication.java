package com.example.test;

import com.example.test.model.Category;
import com.example.test.model.Product;
import com.example.test.repository.CategoryRepository;
import com.example.test.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DistritoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistritoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args, CategoryRepository categoryRepository, ProductRepository productRepository) {
		return runner -> {
			System.out.println("hello Distrilo!");
//			List<Product> products1 = List.of(
//					new Product("Adidas Black Shoe"),
//					new Product("Puma White Shoe"),
//					new Product("Nike Yellow t-shirt"),
//					new Product("Adidas sports t-shirt"),
//					new Product("Adidas Women t-shirt"),
//					new Product("Puma Women Shoe"),
//					new Product("Nike Men t-shirt"),
//					new Product("Adidas Men Green Shoe")
//			);
//			productRepository.saveAll(products1);

//			List<Category> categories = List.of(
//					new Category("Men", null),
//					new Category("Women"),
//					new Category("Shoe"),
//					new Category("T shirt"),
//					new Category("Adidas"),
//					new Category("Puma"),
//					new Category("Nike")
//			);

//			categoryRepository.saveAll(categories);

//			List<Product> shoeProducts = List.of(
//					new Product("Adidas Black Shoe"),
//					new Product("Puma White Shoe")
//			);
//			productRepository.saveAll(shoeProducts);
//
//			List<Product> tshirtProducts = List.of(
//					new Product("Adidas cozy tshirt"),
//					new Product("Puma playing tshirt")
//					);
//			productRepository.saveAll(tshirtProducts);
//
//			List<Category> categories = List.of(
//				new Category("Shoe", shoeProducts),new Category("Tshirt", tshirtProducts)
//			);
//			categoryRepository.saveAll(categories);

//			List<Product> products1 = List.of(
//					new Product("Bata Shoe"),
//					new Product("Apex Shoe"),
//					new Product("Richman t-shirt"),
//					new Product("Easy t-shirt"),
//					new Product("Ecstasy t-shirt"),
//					new Product("Hushpuppies Shoe"),
//					new Product("Infinity t-shirt"),
//					new Product("Zeils Shoe")
//			);
//			productRepository.saveAll(products1);

		};
	}
}
