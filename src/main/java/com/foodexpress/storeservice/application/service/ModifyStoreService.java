package com.foodexpress.storeservice.application.service;

import com.foodexpress.storeservice.application.port.in.command.ModifyStoreCommand;
import com.foodexpress.storeservice.application.port.in.command.ModifyStoreTimesCommand;
import com.foodexpress.storeservice.application.port.in.command.ModifyStoreUseCase;
import com.foodexpress.storeservice.application.port.out.AccountPort;
import com.foodexpress.storeservice.application.port.out.ModifyStorePort;
import com.foodexpress.storeservice.common.UseCase;
import com.foodexpress.storeservice.common.exceptions.OmittedRequireFieldException;
import com.foodexpress.storeservice.domain.account.Account;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class ModifyStoreService implements ModifyStoreUseCase {

    private final ModifyStorePort modifyStorePort;
    private final AccountPort accountPort;

    @Override
    public Store modifyStore(ModifyStoreCommand modifyStoreCommand) {
        Account account = accountPort.findByAccount(modifyStoreCommand.getStoreUserId());

        if (account == null) {
            throw new OmittedRequireFieldException("요청자에 해당하는 상점을 찾을 수 없습니다.");
        }

        Store modifyStore = modifyStoreCommand.mapToDomain();
        return modifyStorePort.modifyStore(modifyStore);
    }

    @Override
    public List<StoreTime> modifyStoreTime(ModifyStoreTimesCommand modifyStoreTimesCommand) {
        Optional<Account> account = Optional.ofNullable(accountPort.findByAccount(modifyStoreTimesCommand.getStoreUserId()));

        if (account.isEmpty()) {
            throw new OmittedRequireFieldException("요청자에 해당하는 상점을 찾을 수 없습니다.");
        }

        List<StoreTime> storeTimes = modifyStoreTimesCommand.mapToDomain();
        return modifyStorePort.modifyStoreTimes(modifyStoreTimesCommand.getStoreId(), storeTimes);
    }

}
