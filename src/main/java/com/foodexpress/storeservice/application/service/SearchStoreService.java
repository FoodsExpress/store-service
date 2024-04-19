package com.foodexpress.storeservice.application.service;

import com.foodexpress.storeservice.application.port.in.SearchStoreQuery;
import com.foodexpress.storeservice.application.port.in.SearchStoreUseCase;
import com.foodexpress.storeservice.application.port.out.SearchStorePort;
import com.foodexpress.storeservice.common.Paged;
import com.foodexpress.storeservice.common.UseCase;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SearchStoreService implements SearchStoreUseCase {

    private final SearchStorePort searchStorePort;

    @Override
    public Paged<Store> getStoreList(SearchStoreQuery searchStoreQuery) {
        return searchStorePort.findAllBySearchCondition(searchStoreQuery.convertCondition());
    }

}
