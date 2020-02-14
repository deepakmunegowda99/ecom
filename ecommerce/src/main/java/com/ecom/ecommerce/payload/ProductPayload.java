package com.ecom.ecommerce.payload;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductPayload {

    @NotNull
    private Long categoryId;

    @NotNull
    private Long subCategoryId;

    @NotNull
    private Long brandId;

    @NotEmpty
    private Set<String> imageurl = new HashSet<String>();

    @NotNull
    private Double actualCost;

    private String discountPercent;
    private Double discountCost;

    @NotNull
    private Integer productCount;

    @NotEmpty
    private Set<Long> sizes = new HashSet<Long>();

    public ProductPayload() {
    }

    public ProductPayload(Long categoryId, Long subCategoryId, Long brandId, Set<String> imageurl, Double actualCost,
            String discountPercent, Double discountCost, Integer productCount, Set<Long> sizes) {
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.brandId = brandId;
        this.imageurl = imageurl;
        this.actualCost = actualCost;
        this.discountPercent = discountPercent;
        this.discountCost = discountCost;
        this.productCount = productCount;
        this.sizes = sizes;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubCategoryId() {
        return this.subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Set<String> getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(Set<String> imageurl) {
        this.imageurl = imageurl;
    }

    public Double getActualCost() {
        return this.actualCost;
    }

    public void setActualCost(Double actualCost) {
        this.actualCost = actualCost;
    }

    public String getDiscountPercent() {
        return this.discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getDiscountCost() {
        return this.discountCost;
    }

    public void setDiscountCost(Double discountCost) {
        this.discountCost = discountCost;
    }

    public Integer getProductCount() {
        return this.productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Set<Long> getSizes() {
        return this.sizes;
    }

    public void setSizes(Set<Long> sizes) {
        this.sizes = sizes;
    }

    public ProductPayload categoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public ProductPayload subCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
        return this;
    }

    public ProductPayload brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public ProductPayload imageurl(Set<String> imageurl) {
        this.imageurl = imageurl;
        return this;
    }

    public ProductPayload actualCost(Double actualCost) {
        this.actualCost = actualCost;
        return this;
    }

    public ProductPayload discountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
        return this;
    }

    public ProductPayload discountCost(Double discountCost) {
        this.discountCost = discountCost;
        return this;
    }

    public ProductPayload productCount(Integer productCount) {
        this.productCount = productCount;
        return this;
    }

    public ProductPayload sizes(Set<Long> sizes) {
        this.sizes = sizes;
        return this;
    }

}