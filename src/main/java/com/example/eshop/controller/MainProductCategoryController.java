package com.example.eshop.controller;

import com.example.eshop.entities.MainProductCategory;
import com.example.eshop.services.MainProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainProductCategoryController {
    private final MainProductCategoryService mainProductCategoryService;

    @GetMapping("/main_categories")
    public ResponseEntity<List<MainProductCategory>> getAllMainProductCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mainProductCategoryService.getAllMainCategories());
    }
}
