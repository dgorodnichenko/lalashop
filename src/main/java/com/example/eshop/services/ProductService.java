package com.example.eshop.services;

import com.example.eshop.entities.Product;
import com.example.eshop.exceptions.ProductNotFoundException;
import com.example.eshop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
        return product;
    }

    public List<Product> getProductsByCategoryId(Long id) {
        List<Product> products = productRepository.findProductsByProductCategoryId(id);
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products with category ID = " + id + " was found");
        }

        return products;
    }

    public List<Product> getProductByName(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }
}
