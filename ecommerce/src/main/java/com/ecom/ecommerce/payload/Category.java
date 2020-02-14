package com.ecom.ecommerce.payload;

public class Category {

    private String name;
    private String description;
    private Integer postion;

    public Category() {
    }

    public Category(String name, String description, Integer postion) {
        this.name = name;
        this.description = description;
        this.postion = postion;
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

    public Integer getPostion() {
        return this.postion;
    }

    public void setPostion(Integer postion) {
        this.postion = postion;
    }

    public Category name(String name) {
        this.name = name;
        return this;
    }

    public Category description(String description) {
        this.description = description;
        return this;
    }

    public Category postion(Integer postion) {
        this.postion = postion;
        return this;
    }

}