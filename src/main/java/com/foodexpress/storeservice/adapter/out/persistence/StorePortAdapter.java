package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreEntity;
import com.foodexpress.storeservice.adapter.out.persistence.repository.StoreRepository;
import com.foodexpress.storeservice.application.port.out.RegisterStorePort;
import com.foodexpress.storeservice.common.PersistenceAdapter;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class StorePortAdapter implements RegisterStorePort {

    private final StoreRepository storeRepository;

    @Override
    public Store saveStore(Store store) {
        StoreEntity storeEntity = StoreEntity.mapToEntity(store);
        storeRepository.save(storeEntity);
        return storeEntity.mapToDomain();
    }

}
