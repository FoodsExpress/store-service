package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.application.port.in.ModifyStoreUseCase;
import com.foodexpress.storeservice.common.BaseRestAnnotation;
import com.foodexpress.storeservice.common.util.ApiUtil;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.foodexpress.storeservice.common.util.ApiUtil.success;

@BaseRestAnnotation
@RequiredArgsConstructor
public class ModifyStoreController {

    private final ModifyStoreUseCase modifyStoreUseCase;

    /**
     * 상점 정보 수정
     *
     * @param modifyStoreRequest
     * @return
     */
    @PatchMapping
    public ApiUtil.ApiResult<ModifyStoreResponse> modifyStore(@RequestBody ModifyStoreRequest modifyStoreRequest) {
        Store store = modifyStoreUseCase.modifyStore(modifyStoreRequest.convertCommand());
        return success(ModifyStoreResponse.of(store));
    }

    /**
     * 상점 시간대 수정
     *
     * @param modifyStoreTimeRequest
     * @return
     */
    @PatchMapping
    public ApiUtil.ApiResult<ModifyStoreTimeResponse> modifyStoreTime(@RequestBody ModifyStoreTimesRequest modifyStoreTimeRequest) {
        List<StoreTime> storeTimes = modifyStoreUseCase.modifyStoreTime(modifyStoreTimeRequest.convertCommand());

        return success(ModifyStoreTimeResponse.of(storeTimes));
    }

}
