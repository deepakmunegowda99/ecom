package com.ecom.ecommerce.repository;

import java.util.Optional;

import com.ecom.ecommerce.model.Categories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Long> {

    Optional<Categories> findByCategoryId(Long id);

    Boolean existsByName(String name);

    Boolean existsByPosition(Integer position);
}