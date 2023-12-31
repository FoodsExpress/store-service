package com.foodexpress.storeservice.common.advice.exceptions;

public class NotValidBusinessNumberException extends RuntimeException {

    public NotValidBusinessNumberException() {
        super();
    }

    public NotValidBusinessNumberException(String message) {
        super(message);
    }

}

