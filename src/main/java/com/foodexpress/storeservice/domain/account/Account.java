package com.foodexpress.storeservice.domain.account;

public class Account {

    private Long id;

    private String accountId;

    /**
     * 추후 account 정보를 갖고오기 위한 객체
     *
     * @return
     */
    public static Account empty() {
        return new Account();
    }
}
