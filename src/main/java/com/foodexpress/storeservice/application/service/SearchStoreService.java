package com.foodexpress.storeservice.application.service;

import com.foodexpress.storeservice.application.port.in.query.SearchStoreQuery;
import com.foodexpress.storeservice.application.port.in.query.SearchStoreUseCase;
import com.foodexpress.storeservice.application.port.out.SearchStorePort;
import com.foodexpress.storeservice.common.UseCase;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class SearchStoreService implements SearchStoreUseCase {

    private final SearchStorePort searchStorePort;

    @Override
    public List<Store> getStoreList(SearchStoreQuery searchStoreQuery, Pageable pageable) {
        return searchStorePort.findAllBySearchCondition(searchStoreQuery.convertCondition(), pageable);
    }

}
