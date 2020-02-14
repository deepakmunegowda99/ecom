package com.ecom.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.ecom.ecommerce.model.Brand;
import com.ecom.ecommerce.model.Categories;
import com.ecom.ecommerce.model.ImageStore;
import com.ecom.ecommerce.model.Product;
import com.ecom.ecommerce.model.ProductSizes;
import com.ecom.ecommerce.model.Sizes;
import com.ecom.ecommerce.model.SubCategories;
import com.ecom.ecommerce.payload.ApiResponse;
import com.ecom.ecommerce.payload.ImageStoreRepository;
import com.ecom.ecommerce.payload.ProductPayload;
import com.ecom.ecommerce.repository.ProductRepository;
import com.ecom.ecommerce.repository.ProductSizesRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageStoreRepository imageStoreRepository;

    @Autowired
    private ProductSizesRepository productSizesRepository;

    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductPayload productPayload) {

        Product product = new Product(new Categories().categoryId(productPayload.getCategoryId()),
                new SubCategories().subcategoryId(productPayload.getSubCategoryId()),
                new Brand().brandId(productPayload.getBrandId()), productPayload.getActualCost(),
                productPayload.getDiscountPercent(), productPayload.getDiscountCost(),
                productPayload.getProductCount());

        final Product savedProduct = productRepository.save(product);

        List<ImageStore> images = new ArrayList<ImageStore>();
        for (String img : productPayload.getImageurl()) {
            ImageStore image = new ImageStore(img, savedProduct);
            images.add(image);
        }
        imageStoreRepository.saveAll(images);

        List<ProductSizes> productSizes = new ArrayList<ProductSizes>();
        for (Long siz : productPayload.getSizes()) {
            ProductSizes size = new ProductSizes(savedProduct, new Sizes().sizeid(siz));
            productSizes.add(size);
        }
        productSizesRepository.saveAll(productSizes);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse(true, "Succesfully added Product", Arrays.asList(savedProduct.getProductId())));

    }

   

}