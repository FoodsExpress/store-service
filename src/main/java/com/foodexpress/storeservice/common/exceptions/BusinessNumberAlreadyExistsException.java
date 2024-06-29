package com.foodexpress.storeservice.common.exceptions;

public class BizNumberAlreadyExistsException extends RuntimeException {

    public BizNumberAlreadyExistsException() {
        super("이미 등록된 사업자 번호입니다.");
    }

    public BizNumberAlreadyExistsException(String message) {
        super(message);
    }

}
