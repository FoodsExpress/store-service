package com.foodexpress.storeservice.application.service;

import com.foodexpress.storeservice.application.port.in.command.RegisterStoreCommand;
import com.foodexpress.storeservice.application.port.in.command.RegisterStoreUseCase;
import com.foodexpress.storeservice.application.port.out.RegisterStorePort;
import com.foodexpress.storeservice.common.UseCase;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterStoreService implements RegisterStoreUseCase {

    private final RegisterStorePort registerStorePort;

    @Override
    public Store registerStore(RegisterStoreCommand registerStoreCommand) {
        Store store = registerStoreCommand.mapToDomain();
        return registerStorePort.saveStore(store);
    }

}
