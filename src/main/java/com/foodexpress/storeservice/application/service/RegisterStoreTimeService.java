package com.foodexpress.storeservice.application.service;

import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeCommand;
import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeUseCase;
import com.foodexpress.storeservice.application.port.out.RegisterStoreTimePort;
import com.foodexpress.storeservice.common.UseCase;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterStoreTimeService implements RegisterStoreTimeUseCase {

    private final RegisterStoreTimePort registerStoreTimePort;

    @Override
    public List<StoreTime> registerStoreTime(List<RegisterStoreTimeCommand> timeCommandList) {
        List<StoreTime> storeTimeList = timeCommandList.stream().map(RegisterStoreTimeCommand::mapToDomain).toList();
        return registerStoreTimePort.saveStoreTimes(storeTimeList);
    }

}
