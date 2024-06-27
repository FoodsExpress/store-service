package com.foodexpress.storeservice.common.exceptions;

public class OmittedRequireFieldException extends RuntimeException {

    public OmittedRequireFieldException() {
        super();
    }

    public OmittedRequireFieldException(String message) {
        super(message);
    }

}
