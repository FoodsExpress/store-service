package com.foodexpress.storeservice.adapter.in.web.modify;

import com.foodexpress.storeservice.domain.store.Store;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ModifyStoreResponse {

    private Store store;

    public static ModifyStoreResponse of(Store store) {
        return new ModifyStoreResponse(store);
    }

}
