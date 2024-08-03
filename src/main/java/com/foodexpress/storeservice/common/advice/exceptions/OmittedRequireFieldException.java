package com.foodexpress.storeservice.common.advice.exceptions;

public class OmittedRequireFieldException extends RuntimeException {

    public OmittedRequireFieldException() {
        super();
    }

    public OmittedRequireFieldException(String message) {
        super(message);
    }

}
