package com.foodexpress.storeservice.common;

import com.foodexpress.storeservice.common.exceptions.NotValidBusinessNumberException;
import com.foodexpress.storeservice.common.util.ApiUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.foodexpress.storeservice.common.util.ApiUtil.fail;

public class ExceptionAdvice {

    public ApiUtil.ApiResult<?> sendError(Exception e, HttpStatus status) {
        return fail(e, status);
    }

    @ExceptionHandler(NotValidBusinessNumberException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtil.ApiResult<?> notValidBusinessNumber(NotValidBusinessNumberException notValidBusinessNumberException) {
        return sendError(notValidBusinessNumberException, HttpStatus.BAD_REQUEST);
    }

}
