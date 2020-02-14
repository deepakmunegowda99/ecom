package com.ecom.ecommerce.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.Valid;

import com.ecom.ecommerce.model.Brand;
import com.ecom.ecommerce.payload.ApiResponse;
import com.ecom.ecommerce.payload.BrandLoad;
import com.ecom.ecommerce.repository.BrandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @Autowired
    private BrandRepository brandRespository;

    @PostMapping
    public ResponseEntity<?> addBrand(@Valid @RequestBody BrandLoad brandLoad) {
        if (brandRespository.existsByBrandName(brandLoad.getBrandName())) {
            return new ResponseEntity(new ApiResponse(false, "Brand is already taken!", null), HttpStatus.BAD_REQUEST);
        }
        Brand brand = new Brand(brandLoad.getBrandType(), brandLoad.getBrandName(), brandLoad.getDescription());
        final Brand result = brandRespository.save(brand);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "Category Added successfully", new ArrayList<>(Arrays.asList(result))));

    }

    @GetMapping
    public ResponseEntity<?> getAllBrands() {
        final ArrayList<Brand> result = (ArrayList) brandRespository.findAll();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "All brand fetched successfully", result));
    }

}