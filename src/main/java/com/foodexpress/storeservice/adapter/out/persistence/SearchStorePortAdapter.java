package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.adapter.out.persistence.repository.StoreRepository;
import com.foodexpress.storeservice.application.port.out.SearchStorePort;
import com.foodexpress.storeservice.common.PersistenceAdapter;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SearchStorePortAdapter implements SearchStorePort {

    private final StoreRepository storeRepository;

    @Override
    public List<Store> findAllBySearchCondition(StoreSearchCondition searchCondition, Pageable pageable) {
        return storeRepository.findAllBySearchCondition(searchCondition, pageable);
    }

}
