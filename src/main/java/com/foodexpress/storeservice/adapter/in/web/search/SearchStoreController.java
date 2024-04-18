package com.foodexpress.storeservice.adapter.in.web.search;

import com.foodexpress.storeservice.application.port.in.SearchStoreUseCase;
import com.foodexpress.storeservice.common.PageMeta;
import com.foodexpress.storeservice.common.Paged;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchStoreController {

    private final SearchStoreUseCase searchStoreUseCase;

    @GetMapping("/store")
    public Paged<StoreInfo> getStoreList(SearchStoreRequest searchStoreRequest) {
        Paged<Store> storePaged = searchStoreUseCase.getStoreList(searchStoreRequest.convertQuery());
        List<StoreInfo> storeInfos = storePaged.data().stream().map(StoreInfo::from).toList();
        return new Paged<>(PageMeta.of(storePaged.meta().isHasMore()), storeInfos);
    }

}
