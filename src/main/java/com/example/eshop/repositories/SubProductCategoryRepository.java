package com.example.eshop.repositories;

import com.example.eshop.entities.SubProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubProductCategoryRepository extends JpaRepository<SubProductCategory, Long> {
}
