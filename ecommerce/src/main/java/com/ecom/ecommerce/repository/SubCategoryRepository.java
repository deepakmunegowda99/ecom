package com.ecom.ecommerce.repository;

import com.ecom.ecommerce.model.SubCategories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategories, Long> {

    Boolean existsByName(String name);
}