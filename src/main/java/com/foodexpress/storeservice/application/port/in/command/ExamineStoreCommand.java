package com.foodexpress.storeservice.application.port.in.command;

import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.store.StoreStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExamineStoreCommand {

    private String storeId;

    private StoreStatus storeStatus;

    private String userId;

    private String examineReason;

    public Store mapToDomain() {

        return Store.builder()
            .storeId(storeId)
            .storeStatus(storeStatus)
            .updatedBy(userId)
            .examineReason(examineReason)
            .build()
            ;
    }

}
