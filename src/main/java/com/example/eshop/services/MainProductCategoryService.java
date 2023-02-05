package com.example.eshop.services;

import com.example.eshop.entities.MainProductCategory;
import com.example.eshop.repositories.MainProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainProductCategoryService {
    private final MainProductCategoryRepository mainProductCategoryRepository;

    public List<MainProductCategory> getAllMainCategories() {
        return mainProductCategoryRepository.findAll();
    }
}
