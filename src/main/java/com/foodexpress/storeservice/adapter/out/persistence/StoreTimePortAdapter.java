package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreTimeEntity;
import com.foodexpress.storeservice.application.port.out.RegisterStoreTimePort;
import com.foodexpress.storeservice.common.PersistenceAdapter;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class StoreTimePortAdapter implements RegisterStoreTimePort {

    private final StoreTimeRepository storeTimeRepository;

    @Override
    public List<StoreTime> saveStoreTimes(List<StoreTime> storeTimeList) {
        List<StoreTimeEntity> timeEntityList = storeTimeList.stream().map(StoreTimeEntity::mapToEntity).toList();
        storeTimeRepository.saveAll(timeEntityList);
        return timeEntityList.stream().map(StoreTimeEntity::mapToDomain).toList();
    }

}
