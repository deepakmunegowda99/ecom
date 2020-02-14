package com.ecom.ecommerce.payload;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {
    private Boolean success;
    private String message;
    private List data = new ArrayList<>();

    public ApiResponse(Boolean success, String message, List data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getData() {
        return this.data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
