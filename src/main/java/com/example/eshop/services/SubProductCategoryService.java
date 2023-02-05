package com.example.eshop.services;

import com.example.eshop.entities.SubProductCategory;
import com.example.eshop.repositories.SubProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubProductCategoryService {
    private final SubProductCategoryRepository subProductCategoryRepository;

    public List<SubProductCategory> getAllSubcategories() {
        return subProductCategoryRepository.findAll();
    }
}
