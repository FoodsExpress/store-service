package com.foodexpress.storeservice.application.port.in.query;

import com.foodexpress.storeservice.domain.store.Store;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchStoreUseCase {

    List<Store> getStoreList(SearchStoreQuery searchStoreQuery, Pageable pageable);

}
