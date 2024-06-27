package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.adapter.out.persistence.repository.StoreRepository;
import com.foodexpress.storeservice.application.port.out.SearchStorePort;
import com.foodexpress.storeservice.common.Paged;
import com.foodexpress.storeservice.common.PersistenceAdapter;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@PersistenceAdapter
@RequiredArgsConstructor
public class SearchStorePortAdapter implements SearchStorePort {

    private final StoreRepository storeRepository;

    @Override
    public Paged<Store> findAllBySearchCondition(StoreSearchCondition searchCondition) {
        Pageable pageable = Pageable.ofSize(searchCondition.getSize());
        Slice<Store> allBySearchCondition = storeRepository.findAllBySearchCondition(searchCondition, pageable);
        return new Paged<>(allBySearchCondition.hasNext(), allBySearchCondition.getContent());
    }

}
