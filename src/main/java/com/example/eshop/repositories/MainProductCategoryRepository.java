package com.example.eshop.repositories;

import com.example.eshop.entities.MainProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainProductCategoryRepository extends JpaRepository<MainProductCategory, Long> {
}
