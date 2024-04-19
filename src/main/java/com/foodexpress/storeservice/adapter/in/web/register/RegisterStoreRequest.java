package com.foodexpress.storeservice.adapter.in.web.register;

import com.foodexpress.storeservice.application.port.in.RegisterStoreCommand;
import com.foodexpress.storeservice.domain.store.StoreType;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class RegisterStoreRequest {

    /**
     * 사업자 등록번호
     */
    private String bizNo;

    /**
     * 점주 식별자
     */
    private String storeUserId;

    /**
     * 프랜차이즈 식별자
     */
    private String franchiseId;

    /**
     * <p>상점 유형</p>
     * 법인, 개인사업자 등
     */
    private StoreType storeType;

    /**
     * 가게 이름
     */
    private String storeName;

    /**
     * 상점 시작 일자
     */
    private LocalDate startedAt;

    /**
     * 주소
     */
    private RegisterAddressRequest address;

    private List<RegisterStoreTimeRequest> storeTimeList = new ArrayList<>();
    /**
     * 원산지
     * COS 라고도 불림.
     */
    private String certificateOfAnalysis;

    public RegisterStoreCommand convertCommand() {
        RegisterStoreCommand registerStoreCommand = new RegisterStoreCommand();
        copyProperties(this, registerStoreCommand);
        if (address != null) {
            registerStoreCommand.setAddress(address.mapToDomain());
        }
        return registerStoreCommand;
    }

}
