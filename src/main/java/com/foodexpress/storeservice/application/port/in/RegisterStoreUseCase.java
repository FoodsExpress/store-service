package com.foodexpress.storeservice.application.port.in;

import com.foodexpress.storeservice.domain.store.Store;

public interface RegisterStoreUseCase {

    Store registerStore(RegisterStoreCommand registerStoreCommand);

}
