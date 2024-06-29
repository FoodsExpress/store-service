package com.foodexpress.storeservice.adapter.in.web.register;

import com.foodexpress.storeservice.application.port.in.command.RegisterStoreUseCase;
import com.foodexpress.storeservice.common.util.ApiUtil.ApiResult;
import com.foodexpress.storeservice.domain.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.foodexpress.storeservice.common.util.ApiUtil.success;

@RestController
@RequiredArgsConstructor
public class RegisterStoreController {

    private final RegisterStoreUseCase registerStoreUseCase;

    @PostMapping("/store")
    public ApiResult<RegisterStoreResponse> registerStore(@RequestBody RegisterStoreRequest registerStoreRequest) {
        Store store = registerStoreUseCase.registerStore(registerStoreRequest.convertCommand());
        return success(RegisterStoreResponse.of(store));
    }

}
