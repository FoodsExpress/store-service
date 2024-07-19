package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.adapter.out.persistence.repository.StoreRepository;
import com.foodexpress.storeservice.application.port.out.StoreAccountPort;
import com.foodexpress.storeservice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class StoreAccountPortAdapter implements StoreAccountPort {

    private final StoreRepository storeRepository;

    @Override
    public boolean existsByStoreIdAndStoreUserId(String storeId, String userId) {
        return storeRepository.existsByStoreIdAndStoreUserId(storeId, userId);
    }

}
