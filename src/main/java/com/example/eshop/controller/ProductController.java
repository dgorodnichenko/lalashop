package com.example.eshop.controller;

import com.example.eshop.entities.Product;
import com.example.eshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAllProducts());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductById(id));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductsByCategoryId(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam String keyword) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductByName(keyword));
    }
}
