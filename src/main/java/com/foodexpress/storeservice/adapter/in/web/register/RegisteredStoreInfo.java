package com.foodexpress.storeservice.adapter.in.web.register;

import com.foodexpress.storeservice.domain.address.Address;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RegisteredStoreInfo {

    private String storeId;

    private String bizNo;

    private Address address;

    private String franchiseName;

    private String storeType;

    private String storeName;

    private String storeStatus;

    private LocalDate startedAt;

    public static RegisteredStoreInfo from(Store store) {
        RegisteredStoreInfo info = new RegisteredStoreInfo();
        info.storeId = store.storeId();
        info.storeName = store.storeName();
        info.bizNo = store.bizNo().getBizNumber();
        info.address = store.address();
        info.storeType = store.storeType().getStoreTypeName();
        info.storeStatus = store.storeStatus().getStatusName();
        info.startedAt = store.startedAt();
        return info;
    }

}
