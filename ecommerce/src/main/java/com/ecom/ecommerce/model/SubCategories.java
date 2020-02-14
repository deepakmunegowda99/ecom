package com.ecom.ecommerce.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ecom.ecommerce.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "sub_categories")
public class SubCategories extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcategoryId;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    private String displayname;

    @NotBlank
    private String description;

    @NotNull
    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Categories categories;

    public SubCategories() {

    }

    public SubCategories(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public SubCategories(String name, String displayname, String description, Integer position, Categories categories) {
        this.name = name;
        this.displayname = displayname;
        this.description = description;
        this.position = position;
        this.categories = categories;
    }

    public SubCategories(Long subcategoryId, String name, String displayname, String description, Integer position,
            Categories categories) {
        this.subcategoryId = subcategoryId;
        this.name = name;
        this.displayname = displayname;
        this.description = description;
        this.position = position;
        this.categories = categories;
    }

    public Long getSubcategoryId() {
        return this.subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayname() {
        return this.displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategories() {
        return this.categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public SubCategories subcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
        return this;
    }

    public SubCategories name(String name) {
        this.name = name;
        return this;
    }

    public SubCategories displayname(String displayname) {
        this.displayname = displayname;
        return this;
    }

    public SubCategories description(String description) {
        this.description = description;
        return this;
    }

    public SubCategories categories(Categories categories) {
        this.categories = categories;
        return this;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
