package com.foodexpress.storeservice.adapter.in.web.modify;

import com.foodexpress.storeservice.application.port.in.command.ModifyStoreUseCase;
import com.foodexpress.storeservice.common.BaseRestAnnotation;
import com.foodexpress.storeservice.common.util.ApiUtil;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.foodexpress.storeservice.common.util.ApiUtil.success;

/**
 * 상점의 수정 기능을 담당하는 컨트롤러
 *
 * @author seunggu.lee
 */
@BaseRestAnnotation
@RequiredArgsConstructor
public class ModifyStoreController {

    private final ModifyStoreUseCase modifyStoreUseCase;

    /**
     * <p>상점 정보 수정</p>
     * 상점이 승인되기 전까지 정보를 수정할 수 있다.
     *
     * @param modifyStoreRequest 상점 수정 요청 정보
     * @return 변경된 상점 정보
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
    @PatchMapping("/time")
    public ApiUtil.ApiResult<ModifyStoreTimeResponse> modifyStoreTime(@RequestBody ModifyStoreTimesRequest modifyStoreTimeRequest) {
        List<StoreTime> storeTimes = modifyStoreUseCase.modifyStoreTime(modifyStoreTimeRequest.convertCommand());

        return success(ModifyStoreTimeResponse.of(storeTimes));
    }

}
