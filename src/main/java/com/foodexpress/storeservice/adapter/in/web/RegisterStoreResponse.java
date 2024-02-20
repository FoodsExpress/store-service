package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.*;

import java.util.List;

@ToString
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterStoreResponse {

    private Store store;
    private List<StoreTime> storeTimeList;

    public static RegisterStoreResponse of(Store store, List<StoreTime> storeTimeList) {
        return new RegisterStoreResponse(store, storeTimeList);
    }

}
