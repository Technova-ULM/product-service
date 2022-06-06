package com.technova.productservice;


public class ProductNotFound extends Exception{
    private String message;

    public ProductNotFound(String message) {
        super(message);

    }
}
