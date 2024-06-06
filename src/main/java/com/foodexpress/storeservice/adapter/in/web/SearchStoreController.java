package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.application.port.in.query.SearchStoreUseCase;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchStoreController {

    private final SearchStoreUseCase searchStoreUseCase;

    @GetMapping("/store")
    public List<Store> getStoreList(SearchStoreRequest searchStoreRequest, Pageable pageable) {
        return searchStoreUseCase.getStoreList(searchStoreRequest.convertQuery(), pageable);
    }

}
