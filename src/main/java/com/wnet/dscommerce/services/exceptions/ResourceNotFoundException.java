package com.wnet.dscommerce.services.exceptions;
//não exige que tenha Try Catch
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
