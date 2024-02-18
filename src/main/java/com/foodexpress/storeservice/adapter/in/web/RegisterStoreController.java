package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.application.port.in.ModifyStoreUseCase;
import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeCommand;
import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeUseCase;
import com.foodexpress.storeservice.application.port.in.RegisterStoreUseCase;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class RegisterStoreController {

    private final RegisterStoreUseCase registerStoreUseCase;
    private final RegisterStoreTimeUseCase registerStoreTimeUseCase;
    private final ModifyStoreUseCase modifyStoreUseCase;

    @PostMapping("/store")
    public ResponseEntity<RegisterStoreResponse> registerStore(@RequestBody RegisterStoreRequest registerStoreRequest) {
        Store store = registerStoreUseCase.registerStore(registerStoreRequest.convertCommand());
        List<RegisterStoreTimeCommand> timeCommandList = registerStoreRequest.getStoreTimeList()
                                                                             .stream()
                                                                             .map(r -> r.mapToCommand(store.id()))
                                                                             .toList();
        List<StoreTime> storeTimes = registerStoreTimeUseCase.registerStoreTime(timeCommandList);
        return ResponseEntity.ok(RegisterStoreResponse.of(store, storeTimes));
    }

    /**
     * 상점 정보 수정
     *
     * @param modifyStoreRequest
     * @return
     */
    @PatchMapping
    public ResponseEntity<ModifyStoreResponse> modifyStore(@RequestBody ModifyStoreRequest modifyStoreRequest) {
        Store store = modifyStoreUseCase.modifyStore(modifyStoreRequest.convertCommand());
        return ResponseEntity.ok(ModifyStoreResponse.of(store));
    }

    /**
     * 상점 시간대 수정
     *
     * @param modifyStoreTimeRequest
     * @return
     */
    @PatchMapping
    public ResponseEntity<ModifyStoreTimeResponse> modifyStoreTime(@RequestBody ModifyStoreTimesRequest modifyStoreTimeRequest) {
        List<StoreTime> storeTimes = modifyStoreUseCase.modifyStoreTime(modifyStoreTimeRequest.convertCommand());

        return ResponseEntity.ok(ModifyStoreTimeResponse.of(storeTimes));
    }
}
