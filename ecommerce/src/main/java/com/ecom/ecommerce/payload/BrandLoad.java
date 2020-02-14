package com.ecom.ecommerce.payload;

public class BrandLoad {

    private String brandType;
    private String brandName;
    private String description;

    public BrandLoad() {
    }

    public BrandLoad(String brandType, String brandName, String description) {
        this.brandType = brandType;
        this.brandName = brandName;
        this.description = description;
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

    public BrandLoad brandType(String brandType) {
        this.brandType = brandType;
        return this;
    }

    public BrandLoad brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public BrandLoad description(String description) {
        this.description = description;
        return this;
    }

}