package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreEntity;
import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreTimeEntity;
import com.foodexpress.storeservice.adapter.out.persistence.repository.StoreRepository;
import com.foodexpress.storeservice.application.port.out.ModifyStorePort;
import com.foodexpress.storeservice.common.PersistenceAdapter;
import com.foodexpress.storeservice.common.exceptions.OmittedRequireFieldException;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
@RequiredArgsConstructor
public class ModifyStorePortAdapter implements ModifyStorePort {

    private final StoreRepository storeRepository;

    private final StoreTimeRepository storeTimeRepository;

    @Override
    @Transactional
    public Store modifyStore(Store store) {
        StoreEntity modifyStore = storeRepository.findByStoreId(store.storeId())
            .orElseThrow(() -> new OmittedRequireFieldException("일치하는 상점을 찾을 수 없습니다."));
        modifyStore.modify(store);
        return modifyStore.mapToDomain();
    }

    @Override
    @Transactional
    public List<StoreTime> modifyStoreTimes(String storeId, List<StoreTime> storeTimes) {
        StoreEntity storeEntity = storeRepository.findByStoreId(storeId)
            .orElseThrow(() -> new OmittedRequireFieldException("일치하는 상점을 찾을 수 없습니다."));

        Set<StoreTimeEntity> storeTimeList = storeEntity.getStoreTimeList();
        List<String> existStoreTimeId = new ArrayList<>();
        for (StoreTime storeTime : storeTimes) {
            Optional<String> optionalStoreTime = Optional.ofNullable(storeTime.storeTimeId());

            if (optionalStoreTime.isPresent()) {
                StoreTimeEntity storeTimeEntity = storeTimeRepository.findByStoreTimeId(optionalStoreTime.get())
                    .orElseThrow(() -> new OmittedRequireFieldException("일치하는 상점 시간을 찾을 수 없습니다."));

                storeTimeEntity.modifyStoreTime(storeTime);
                existStoreTimeId.add(storeTime.storeTimeId());
            } else {
                StoreTimeEntity storeTimeEntity = StoreTimeEntity.mapToEntity(storeTime);
                storeTimeRepository.save(storeTimeEntity);
            }

        }

        List<Long> deleteStoreTimeIdList = new ArrayList<>();
        for (StoreTimeEntity storeTimeEntity : storeTimeList) {
            if (!existStoreTimeId.contains(storeTimeEntity.getStoreTimeId())) {
                deleteStoreTimeIdList.add(storeTimeEntity.getId());
            }
        }

        storeTimeRepository.deleteAllByIdInBatch(deleteStoreTimeIdList);

        return storeEntity.storeTimeListToDomain();
    }

}
