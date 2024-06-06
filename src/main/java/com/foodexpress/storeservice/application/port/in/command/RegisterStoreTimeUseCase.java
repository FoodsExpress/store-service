package com.foodexpress.storeservice.application.port.in.command;

import com.foodexpress.storeservice.domain.storetime.StoreTime;

import java.util.List;

public interface RegisterStoreTimeUseCase {

    List<StoreTime> registerStoreTime(List<RegisterStoreTimeCommand> timeCommandList);

}
