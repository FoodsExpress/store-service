package com.foodexpress.storeservice.common.advice.exceptions;

public class BusinessNumberAlreadyExistsException extends RuntimeException {

    public BusinessNumberAlreadyExistsException() {
        super("이미 등록된 사업자 번호입니다.");
    }

    public BusinessNumberAlreadyExistsException(String message) {
        super(message);
    }

}
