package com.foodexpress.storeservice.application.service;

import com.foodexpress.storeservice.application.port.in.command.ModifyStoreCommand;
import com.foodexpress.storeservice.application.port.in.command.ModifyStoreTimesCommand;
import com.foodexpress.storeservice.application.port.in.command.ModifyStoreUseCase;
import com.foodexpress.storeservice.application.port.out.ModifyStorePort;
import com.foodexpress.storeservice.common.UseCase;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 상점 수정 서비스
 *
 * @author cyeji
 */
@UseCase
@RequiredArgsConstructor
public class ModifyStoreService implements ModifyStoreUseCase {

    private final ModifyStorePort modifyStorePort;

    @Override
    public Store modifyStore(ModifyStoreCommand modifyStoreCommand) {
        return modifyStorePort.modifyStore(modifyStoreCommand.mapToDomain());
    }

    @Override
    public List<StoreTime> modifyStoreTime(ModifyStoreTimesCommand modifyStoreTimesCommand) {
        List<StoreTime> storeTimes = modifyStoreTimesCommand.mapToDomain();
        return modifyStorePort.modifyStoreTimes(modifyStoreTimesCommand.getStoreId(), storeTimes);
    }

}
