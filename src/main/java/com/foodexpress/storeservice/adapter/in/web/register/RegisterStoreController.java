package com.foodexpress.storeservice.adapter.in.web.register;

import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeCommand;
import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeUseCase;
import com.foodexpress.storeservice.application.port.in.RegisterStoreUseCase;
import com.foodexpress.storeservice.common.util.ApiUtil;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.foodexpress.storeservice.common.util.ApiUtil.success;

/**
 * 상점 등록 컨트롤러
 *
 * @author seunggu.lee
 */
@RestController
@RequiredArgsConstructor
public class RegisterStoreController {

    private final RegisterStoreUseCase registerStoreUseCase;
    private final RegisterStoreTimeUseCase registerStoreTimeUseCase;

    /**
     * 상점을 등록한다.
     * 상점을 먼저 등록한 이후 상점의 대한 식별자를 갖고 상점의 시간대를 따로 저장한다.
     *
     * @param registerStoreRequest 상점 등록 정보
     * @return 등록된 상점 정보
     */
    @PostMapping("/store")
    public ApiUtil.ApiResult<RegisterStoreResponse> registerStore(@RequestBody RegisterStoreRequest registerStoreRequest) {
        Store store = registerStoreUseCase.registerStore(registerStoreRequest.convertCommand());
        List<RegisterStoreTimeCommand> timeCommandList = registerStoreRequest.getStoreTimeList()
            .stream()
            .map(r -> r.mapToCommand(store.id()))
            .toList();
        List<StoreTime> storeTimes = registerStoreTimeUseCase.registerStoreTime(timeCommandList);
        return success(RegisterStoreResponse.of(store, storeTimes));
    }

}
