package com.foodexpress.storeservice.adapter.in.web.register;

import com.foodexpress.storeservice.domain.store.Store;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterStoreResponse {

    private RegisteredStoreInfo store;

    public static RegisterStoreResponse of(Store store) {
        RegisterStoreResponse storeInfo = new RegisterStoreResponse();
        storeInfo.store = RegisteredStoreInfo.from(store);
        return storeInfo;
    }

}
