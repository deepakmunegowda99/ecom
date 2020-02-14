package com.ecom.ecommerce.payload;

import com.ecom.ecommerce.model.ImageStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageStoreRepository extends JpaRepository<ImageStore,Long>{

}