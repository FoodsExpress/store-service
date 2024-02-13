package com.foodexpress.storeservice.common.exceptions;

public class NotValidBusinessNumberException extends RuntimeException {

    public NotValidBusinessNumberException() {
        super();
    }

    public NotValidBusinessNumberException(String message) {
        super(message);
    }

}

