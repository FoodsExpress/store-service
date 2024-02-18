package com.foodexpress.storeservice.application.port.out;

import com.foodexpress.storeservice.domain.account.Account;

public interface AccountPort {

    Account findByAccount(String userId);
}
