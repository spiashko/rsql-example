package com.spiashko.rsqlexample.crudbase.exception;

import lombok.Getter;

@Getter
public class RequestedClassNotSupportedException extends RuntimeException {

    private final Class<?> requestedClazz;

    public RequestedClassNotSupportedException(Class<?> requestedClazz) {
        this.requestedClazz = requestedClazz;
    }
}
