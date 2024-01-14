package com.example.cionca;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(long id){
        super("Could not find product " + id);
    }
}
