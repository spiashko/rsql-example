package com.spiashko.rsqlexample.crudbase.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String error) {
        super(error);
    }
}
