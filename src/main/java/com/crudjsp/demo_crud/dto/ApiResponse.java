package com.crudjsp.demo_crud.dto;

import lombok.Data;

@Data
public class ApiResponse {
    private int status;
    private String message;
    private Object data;

    public ApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and setters
}