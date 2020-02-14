package com.ecom.ecommerce.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.ecom.ecommerce.model.Sizes;
import com.ecom.ecommerce.payload.ApiResponse;
import com.ecom.ecommerce.payload.SizePayload;
import com.ecom.ecommerce.repository.SizeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/size")
public class SizeController {

    @Autowired
    SizeRepository sizeRepository;

    @PostMapping
    public ResponseEntity<?> addSizes(@Valid @RequestBody SizePayload sizePayload) {
        Sizes size = new Sizes(sizePayload.getType(), sizePayload.getSize(), sizePayload.getSizingType());
        final Sizes sizes = sizeRepository.save(size);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse(true, "Size Added successfully", new ArrayList<>(Arrays.asList(sizes.getSizeid()))));
    }

    @GetMapping
    public ResponseEntity<?> getSizes(@Valid @RequestBody SizePayload sizePayload) {
        final List<Sizes> sizes = sizeRepository.findAll();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "Size Fetched successfully", new ArrayList<>(Arrays.asList(sizes))));

    }

}