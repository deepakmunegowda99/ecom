package com.ecom.ecommerce.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.ecom.ecommerce.model.audit.DateAudit;

@Entity
@Table(name = "brand")
public class Brand extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    @NotBlank
    private String brandType;

    @NotBlank
    @Column(unique = true)
    private String brandName;

    @NotBlank
    private String description;

    public Brand() {
    }

    public Brand(Long brandId) {
        this.brandId = brandId;
    }

    public Brand(String brandType, String brandName, String description) {
        this.brandType = brandType;
        this.brandName = brandName;
        this.description = description;
    }

    public Brand(Long brandId, String brandType, String brandName, String description) {
        this.brandId = brandId;
        this.brandType = brandType;
        this.brandName = brandName;
        this.description = description;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandType() {
        return this.brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brand brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public Brand brandType(String brandType) {
        this.brandType = brandType;
        return this;
    }

    public Brand brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public Brand description(String description) {
        this.description = description;
        return this;
    }

}