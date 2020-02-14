package com.ecom.ecommerce.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ecom.ecommerce.model.audit.DateAudit;

@Entity
@Table(name = "categories")
public class Categories extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank
    private String description;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(unique = true)
    private Integer position;

    public Categories() {
    }

    public Categories(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Categories(String description, String name, Integer position) {
        this.description = description;
        this.name = name;
        this.position = position;
    }

    public Categories(Long categoryId, String description, String name, Integer position) {
        this.categoryId = categoryId;
        this.description = description;
        this.name = name;
        this.position = position;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Categories categoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Categories description(String description) {
        this.description = description;
        return this;
    }

    public Categories name(String name) {
        this.name = name;
        return this;
    }

    public Categories position(Integer position) {
        this.position = position;
        return this;
    }

}