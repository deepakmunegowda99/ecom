package com.ecom.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ecom.ecommerce.model.audit.DateAudit;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categories categories;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subcategory_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubCategories subCategories;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brand;

    @NotNull
    private Double actualCost;

    private String discountPercent;

    private Double discountedCost;

    @NotNull
    private Integer productcount;

    public Product() {
    }

    public Product(Categories categories, SubCategories subCategories, Brand brand, Double actualCost,
            String discountPercent, Double discountedCost, Integer productcount) {
        this.categories = categories;
        this.subCategories = subCategories;
        this.brand = brand;
        this.actualCost = actualCost;
        this.discountPercent = discountPercent;
        this.discountedCost = discountedCost;
        this.productcount = productcount;
    }

    public Product(Long productId, Categories categories, SubCategories subCategories, Brand brand, Double actualCost,
            String discountPercent, Double discountedCost, Integer productcount) {
        this.productId = productId;
        this.categories = categories;
        this.subCategories = subCategories;
        this.brand = brand;
        this.actualCost = actualCost;
        this.discountPercent = discountPercent;
        this.discountedCost = discountedCost;
        this.productcount = productcount;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Categories getCategories() {
        return this.categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public SubCategories getSubCategories() {
        return this.subCategories;
    }

    public void setSubCategories(SubCategories subCategories) {
        this.subCategories = subCategories;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public Double getDiscountedCost() {
        return this.discountedCost;
    }

    public void setDiscountedCost(Double discountedCost) {
        this.discountedCost = discountedCost;
    }

    public Integer getProductcount() {
        return this.productcount;
    }

    public void setProductcount(Integer productcount) {
        this.productcount = productcount;
    }

    public Product productId(Long productId) {
        this.productId = productId;
        return this;
    }

    public Product categories(Categories categories) {
        this.categories = categories;
        return this;
    }

    public Product subCategories(SubCategories subCategories) {
        this.subCategories = subCategories;
        return this;
    }

    public Product brand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public Product actualCost(Double actualCost) {
        this.actualCost = actualCost;
        return this;
    }

    public Product discountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
        return this;
    }

    public Product discountedCost(Double discountedCost) {
        this.discountedCost = discountedCost;
        return this;
    }

    public Product productcount(Integer productcount) {
        this.productcount = productcount;
        return this;
    }

}