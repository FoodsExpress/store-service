package com.foodexpress.storeservice.adapter.in.web.search;

import com.foodexpress.storeservice.application.port.in.query.SearchStoreUseCase;
import com.foodexpress.storeservice.common.Paged;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 상점에 대한 정보를 조회하는 컨트롤러
 *
 * @author seunggu.lee
 */
@RestController
@RequiredArgsConstructor
public class SearchStoreController {

    private final SearchStoreUseCase searchStoreUseCase;

    /**
     * 넘겨진 검색 정보를 통해 상점의 목록을 페이징 처리한다.
     *
     * @param searchStoreRequest 조회할 상점 정보
     * @return 페이징 처리 된 상점 정보
     */
    @GetMapping("/store")
    public Paged<StoreInfo> getStoreList(SearchStoreRequest searchStoreRequest) {
        Paged<Store> storePaged = searchStoreUseCase.getStoreList(searchStoreRequest.convertQuery());
        List<StoreInfo> storeInfos = storePaged.data().stream().map(StoreInfo::from).toList();
        return new Paged<>(storePaged.hasMore(), storeInfos);
    }

}
