package com.ecom.ecommerce.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.ecommerce.payload.ApiResponse;
import com.ecom.ecommerce.payload.Category;
import com.ecom.ecommerce.payload.SubCategory;
import com.ecom.ecommerce.repository.*;
import com.ecom.ecommerce.model.Categories;
import com.ecom.ecommerce.model.SubCategories;
import com.ecom.ecommerce.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @PostMapping
    public ResponseEntity<?> addCatergory(@Valid @RequestBody final Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            return new ResponseEntity(new ApiResponse(false, "Category is already taken!", null),
                    HttpStatus.BAD_REQUEST);
        }
        if (categoryRepository.existsByPosition(category.getPostion())) {
            return new ResponseEntity(new ApiResponse(false, "Position is already taken!", null),
                    HttpStatus.BAD_REQUEST);
        }
        final Categories saveCategory = new Categories(category.getDescription(), category.getName(),
                category.getPostion());
        final Categories result = categoryRepository.save(saveCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Category Added successfully",
                Arrays.asList(result.getCategoryId())));
    }

    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        final ArrayList<Categories> data = (ArrayList) categoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse(true, "Fetched all categories successfully", data));
    }

    @PostMapping("/sub")
    public ResponseEntity<?> addSubCatergory(@Valid @RequestBody final SubCategory subCategory) {

        if (subCategoryRepository.existsByName(subCategory.getName())) {
            return new ResponseEntity(new ApiResponse(false, "Sub Category is already taken!", null),
                    HttpStatus.BAD_REQUEST);
        }

        Categories categories = categoryRepository.findByCategoryId(subCategory.getCategoryId()).orElseThrow(
                () -> new ResourceNotFoundException("Category not found", "Category id", subCategory.getCategoryId()));

        final SubCategories saveCategory = new SubCategories(subCategory.getName(), subCategory.getDisplayName(),
                subCategory.getDescription(), subCategory.getPosition(), categories);

        final SubCategories result = subCategoryRepository.save(saveCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Sub Category Added successfully",
                Arrays.asList(result.getSubcategoryId())));
    }

    @GetMapping("/sub")
    public ResponseEntity<?> getAllSubCategory() {
        final ArrayList<SubCategories> data = (ArrayList) subCategoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse(true, "Fetched all categories successfully", data));
    }

}