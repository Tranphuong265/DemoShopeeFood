package com.example.shopee.Model;

import java.util.List;

public class QuanModel {
    boolean success;
    String message;
    List<Quan>result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Quan> getResult() {
        return result;
    }

    public void setResult(List<Quan> result) {
        this.result = result;
    }
}
