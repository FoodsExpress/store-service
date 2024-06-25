package com.foodexpress.storeservice.application.port.in.query;

import com.foodexpress.storeservice.common.Paged;
import com.foodexpress.storeservice.domain.store.Store;

public interface SearchStoreUseCase {

    Paged<Store> getStoreList(SearchStoreQuery searchStoreQuery);

}
