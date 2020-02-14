package com.ecom.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.ecom.ecommerce.model.audit.DateAudit;

@Entity
@Table(name = "sizes")
public class Sizes extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id")
    private Long sizeid;

    @NotBlank /// clothing or footware
    private String type;

    @NotBlank
    private String size;

    @NotBlank
    private String sizingtype;

    public Sizes() {
    }

    public Sizes(String type, String size, String sizingtype) {
        this.type = type;
        this.size = size;
        this.sizingtype = sizingtype;
    }

    public Sizes(Long sizeid, String type, String size, String sizingtype) {
        this.sizeid = sizeid;
        this.type = type;
        this.size = size;
        this.sizingtype = sizingtype;
    }

    public Long getSizeid() {
        return this.sizeid;
    }

    public void setSizeid(Long sizeid) {
        this.sizeid = sizeid;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizingtype() {
        return this.sizingtype;
    }

    public void setSizingtype(String sizingtype) {
        this.sizingtype = sizingtype;
    }

    public Sizes sizeid(Long sizeid) {
        this.sizeid = sizeid;
        return this;
    }

    public Sizes type(String type) {
        this.type = type;
        return this;
    }

    public Sizes size(String size) {
        this.size = size;
        return this;
    }

    public Sizes sizingtype(String sizingtype) {
        this.sizingtype = sizingtype;
        return this;
    }

}