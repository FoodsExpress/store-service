package com.foodexpress.storeservice.application.port.out;

import com.foodexpress.storeservice.domain.storetime.StoreTime;

import java.util.List;

public interface RegisterStoreTimePort {

    List<StoreTime> saveStoreTimes(List<StoreTime> storeTimeList);

}
