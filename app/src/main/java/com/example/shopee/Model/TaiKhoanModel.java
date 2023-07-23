package com.example.shopee.Model;

import java.util.List;

public class TaiKhoanModel {
    boolean success;
    String message;
    List<Taikhoan> result;

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

    public List<Taikhoan> getResult() {
        return result;
    }

    public void setResult(List<Taikhoan> result) {
        this.result = result;
    }
}
