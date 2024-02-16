package com.foodexpress.storeservice.application.port.out;

import com.foodexpress.storeservice.domain.store.Store;

public interface RegisterStorePort {

    Store saveStore(Store store);

}
