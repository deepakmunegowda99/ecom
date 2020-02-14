package com.ecom.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ecom.ecommerce.model.audit.DateAudit;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "product_sizes")
public class ProductSizes extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productsizeid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sizes sizes;

    public ProductSizes() {
    }

    public ProductSizes(Product product, Sizes sizes) {
        this.product = product;
        this.sizes = sizes;
    }

    public ProductSizes(Long productsizeid, Product product, Sizes sizes) {
        this.productsizeid = productsizeid;
        this.product = product;
        this.sizes = sizes;
    }

    public Long getProductsizeid() {
        return this.productsizeid;
    }

    public void setProductsizeid(Long productsizeid) {
        this.productsizeid = productsizeid;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sizes getSizes() {
        return this.sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public ProductSizes productsizeid(Long productsizeid) {
        this.productsizeid = productsizeid;
        return this;
    }

    public ProductSizes product(Product product) {
        this.product = product;
        return this;
    }

    public ProductSizes sizes(Sizes sizes) {
        this.sizes = sizes;
        return this;
    }

}