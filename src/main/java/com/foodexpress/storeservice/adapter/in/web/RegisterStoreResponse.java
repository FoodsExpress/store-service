package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterStoreResponse {

    private Store store;
    private List<StoreTime> storeTimeList;

    public static RegisterStoreResponse of(Store store, List<StoreTime> storeTimeList) {
        return new RegisterStoreResponse(store, storeTimeList);
    }

}
