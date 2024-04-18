package com.foodexpress.storeservice.adapter.out.persistence.repository;

import com.foodexpress.storeservice.adapter.out.persistence.StoreSearchCondition;
import com.foodexpress.storeservice.domain.store.Store;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface StoreRepositoryQuerydsl {

    Slice<Store> findAllBySearchCondition(StoreSearchCondition searchCondition, Pageable pageable);

}
