package com.nttdata.bc19.msmanagementclientproduct.exception;

public class ProductNotFoundException extends RuntimeException{
    private static final String MESSAGE = "PRODUCT NOT FOUND";

    public ProductNotFoundException(){
        super(MESSAGE);
    }
}
