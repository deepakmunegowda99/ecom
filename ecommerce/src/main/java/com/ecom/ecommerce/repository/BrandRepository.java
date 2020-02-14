package com.ecom.ecommerce.repository;

import com.ecom.ecommerce.model.Brand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Boolean existsByBrandName(String name);
}
