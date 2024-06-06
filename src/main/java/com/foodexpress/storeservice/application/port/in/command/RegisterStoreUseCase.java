package com.foodexpress.storeservice.application.port.in.command;

import com.foodexpress.storeservice.domain.store.Store;

public interface RegisterStoreUseCase {

    Store registerStore(RegisterStoreCommand registerStoreCommand);

}
