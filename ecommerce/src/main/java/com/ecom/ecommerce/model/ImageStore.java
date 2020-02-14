package com.ecom.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.ecom.ecommerce.model.audit.DateAudit;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "image_store")
public class ImageStore extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageid;

    @NotBlank
    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    public ImageStore() {
    }

    public ImageStore(String imageURL, Product product) {
        this.imageURL = imageURL;
        this.product = product;
    }

    public ImageStore(Long imageid, String imageURL, Product product) {
        this.imageid = imageid;
        this.imageURL = imageURL;
        this.product = product;
    }

    public Long getImageid() {
        return this.imageid;
    }

    public void setImageid(Long imageid) {
        this.imageid = imageid;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ImageStore imageid(Long imageid) {
        this.imageid = imageid;
        return this;
    }

    public ImageStore imageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public ImageStore product(Product product) {
        this.product = product;
        return this;
    }

}