package com.ecom.ecommerce.repository;

import com.ecom.ecommerce.model.Sizes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Sizes, Long> {

}