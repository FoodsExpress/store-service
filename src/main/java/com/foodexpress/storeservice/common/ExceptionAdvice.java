package com.foodexpress.storeservice.common;

import com.foodexpress.storeservice.common.exceptions.NotValidBusinessNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionAdvice {

    @ExceptionHandler(NotValidBusinessNumberException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> notValidBusinessNumber(NotValidBusinessNumberException notValidBusinessNumberException) {
        return null;
    }

}
