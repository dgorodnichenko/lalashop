package com.example.eshop.controller;

import com.example.eshop.entities.SubProductCategory;
import com.example.eshop.services.SubProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubProductCategoryController {
    private final SubProductCategoryService subProductCategoryService;

    @GetMapping("/subcategories")
    public ResponseEntity<List<SubProductCategory>> getAllSubCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subProductCategoryService.getAllSubcategories());
    }
}
