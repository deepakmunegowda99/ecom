package com.ecom.ecommerce.repository;

import com.ecom.ecommerce.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{

}