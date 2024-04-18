package com.foodexpress.storeservice.adapter.in.web.register;

import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeCommand;
import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeUseCase;
import com.foodexpress.storeservice.application.port.in.RegisterStoreUseCase;
import com.foodexpress.storeservice.common.util.ApiUtil.ApiResult;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.foodexpress.storeservice.common.util.ApiUtil.success;

@RestController
@RequiredArgsConstructor
public class RegisterStoreController {

    private final RegisterStoreUseCase registerStoreUseCase;
    private final RegisterStoreTimeUseCase registerStoreTimeUseCase;

    @PostMapping("/store")
    public ApiResult<RegisterStoreResponse> registerStore(@RequestBody RegisterStoreRequest registerStoreRequest) {
        Store store = registerStoreUseCase.registerStore(registerStoreRequest.convertCommand());
        List<RegisterStoreTimeCommand> timeCommandList = registerStoreRequest.getStoreTimeList()
            .stream()
            .map(r -> r.mapToCommand(store.id()))
            .toList();
        List<StoreTime> storeTimes = registerStoreTimeUseCase.registerStoreTime(timeCommandList);
        return success(RegisterStoreResponse.of(store, storeTimes));
    }

}
