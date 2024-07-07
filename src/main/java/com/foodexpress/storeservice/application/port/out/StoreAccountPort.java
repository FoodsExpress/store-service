package com.foodexpress.storeservice.application.port.out;

public interface StoreAccountPort {

    boolean existsByStoreIdAndStoreUserId(String storeId, String userId);

}
