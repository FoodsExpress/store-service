package com.foodexpress.storeservice.application.port.out;

import com.foodexpress.storeservice.adapter.out.persistence.StoreSearchCondition;
import com.foodexpress.storeservice.common.Paged;
import com.foodexpress.storeservice.domain.store.Store;

public interface SearchStorePort {

    Paged<Store> findAllBySearchCondition(StoreSearchCondition searchCondition);

}
