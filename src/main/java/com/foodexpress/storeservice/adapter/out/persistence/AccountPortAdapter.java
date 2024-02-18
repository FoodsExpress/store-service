package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.application.port.out.AccountPort;
import com.foodexpress.storeservice.common.PersistenceAdapter;
import com.foodexpress.storeservice.domain.account.Account;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class AccountPortAdapter implements AccountPort {

    @Override
    public Account findByAccount(String userId) {
        return Account.empty();
    }
}
