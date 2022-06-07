package com.nttdata.bc19.msmanagementclientproduct.exception;

public class ClientNotFoundException extends RuntimeException{
    private static final String MESSAGE = "CLIENT NOT FOUND";

    public ClientNotFoundException(){
        super(MESSAGE);
    }
}
