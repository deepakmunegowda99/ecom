package com.ecom.ecommerce.payload;

public class SubCategory {

    private String name;
    private String description;
    private Long categoryId;
    private Integer position;
    private String displayName;

    public SubCategory() {
    }

    public SubCategory(String name, String description, Long categoryId, Integer position, String displayName) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.position = position;
        this.displayName = displayName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public SubCategory name(String name) {
        this.name = name;
        return this;
    }

    public SubCategory description(String description) {
        this.description = description;
        return this;
    }

    public SubCategory categoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public SubCategory position(Integer position) {
        this.position = position;
        return this;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}