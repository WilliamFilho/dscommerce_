package com.wnet.dscommerce.services.exceptions;
//não exige que tenha Try Catch
public class DatabaseException extends RuntimeException{
    public DatabaseException(String message) {
        super(message);
    }
}
