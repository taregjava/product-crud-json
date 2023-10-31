package com.crudjsp.demo_crud.errorss;

public class InvalidProductException extends RuntimeException{

    public InvalidProductException(String message) {
        super(message);
    }
}
