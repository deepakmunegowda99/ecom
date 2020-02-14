package com.ecom.ecommerce.payload;

import javax.validation.constraints.NotBlank;

public class SizePayload {

    private Long sizeId;
    
    @NotBlank
    private String type;
    
    @NotBlank
    private String size;
    
    @NotBlank
    private String sizingType;

    public SizePayload() {
    }

    public SizePayload(String type, String size, String sizingType) {
        this.type = type;
        this.size = size;
        this.sizingType = sizingType;
    }

    public SizePayload(Long sizeId, String type, String size, String sizingType) {
        this.sizeId = sizeId;
        this.type = type;
        this.size = size;
        this.sizingType = sizingType;
    }

    public Long getSizeId() {
        return this.sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
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

    public String getSizingType() {
        return this.sizingType;
    }

    public void setSizingType(String sizingType) {
        this.sizingType = sizingType;
    }

    public SizePayload sizeId(Long sizeId) {
        this.sizeId = sizeId;
        return this;
    }

    public SizePayload type(String type) {
        this.type = type;
        return this;
    }

    public SizePayload size(String size) {
        this.size = size;
        return this;
    }

    public SizePayload sizingType(String sizingType) {
        this.sizingType = sizingType;
        return this;
    }

}