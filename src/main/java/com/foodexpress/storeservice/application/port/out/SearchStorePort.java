package com.foodexpress.storeservice.application.port.out;

import com.foodexpress.storeservice.adapter.out.persistence.StoreSearchCondition;
import com.foodexpress.storeservice.domain.store.Store;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchStorePort {

    List<Store> findAllBySearchCondition(StoreSearchCondition searchCondition, Pageable pageable);

}
