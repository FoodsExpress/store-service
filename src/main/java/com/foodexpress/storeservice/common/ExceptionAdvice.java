package com.foodexpress.storeservice.common;

import com.foodexpress.storeservice.common.exceptions.NotValidBusinessNumberException;
import com.foodexpress.storeservice.common.util.ApiUtil;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.foodexpress.storeservice.common.util.ApiUtil.fail;

@RestControllerAdvice
public class ExceptionAdvice {

    public ApiUtil.ApiResult<Void> sendError(Exception e, HttpStatus status) {
        return fail(e, status);
    }

    private ApiUtil.ApiResult<Void> sendError(String message, HttpStatus status) {
        return fail(message, status);
    }

    @ExceptionHandler(NotValidBusinessNumberException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtil.ApiResult<Void> notValidBusinessNumber(NotValidBusinessNumberException notValidBusinessNumberException) {
        return sendError(notValidBusinessNumberException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ApiUtil.ApiResult<Void> validationException(MethodArgumentNotValidException e) {
        return sendError(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ApiUtil.ApiResult<Void> constraintViolationException(ConstraintViolationException e) {
        String message = e.getMessage();
        if (message.contains(",")) {
            message = message.split(",")[0];
        }
        return sendError(message, HttpStatus.BAD_REQUEST);
    }

}
