package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreEntity;
import com.foodexpress.storeservice.adapter.out.persistence.repository.StoreRepository;
import com.foodexpress.storeservice.application.port.out.ExamineStorePort;
import com.foodexpress.storeservice.application.port.out.RegisterStorePort;
import com.foodexpress.storeservice.common.PersistenceAdapter;
import com.foodexpress.storeservice.common.exceptions.BusinessNumberAlreadyExistsException;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class StorePortAdapter implements RegisterStorePort, ExamineStorePort {

    private final StoreRepository storeRepository;

    @Override
    public Store saveStore(Store store) {
        String bizNumber = store.bizNo().getBizNumber();
        if (storeRepository.existsByBizNo(bizNumber))
            throw new BusinessNumberAlreadyExistsException();
        StoreEntity storeEntity = StoreEntity.createNew(store);
        storeRepository.save(storeEntity);
        return storeEntity.mapToDomain();
    }

    @Override
    public void examine(Store store) {
        StoreEntity storeEntity = StoreEntity.mapToEntity(store);
        storeRepository.save(storeEntity);

    }

}
