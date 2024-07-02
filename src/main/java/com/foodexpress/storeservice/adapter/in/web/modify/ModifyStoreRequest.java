package com.foodexpress.storeservice.adapter.in.web.modify;

import com.foodexpress.storeservice.adapter.in.web.register.RegisterAddressRequest;
import com.foodexpress.storeservice.adapter.in.web.register.RegisterStoreTimeRequest;
import com.foodexpress.storeservice.application.port.in.command.ModifyStoreCommand;
import com.foodexpress.storeservice.domain.store.BizNo;
import com.foodexpress.storeservice.domain.store.StoreStatus;
import com.foodexpress.storeservice.domain.store.StoreType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class ModifyStoreRequest {

    /**
     * 사업자 등록번호
     */
    private BizNo bizNo;

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
     * <p>가게 상태</p>
     * 심사중, 거절, 승인, 정상, 휴점, 폐점
     */
    private StoreStatus storeStatus;

    /**
     * 상점 시작 일자
     */
    private LocalDate startedAt;

    /**
     * 주소
     */
    private RegisterAddressRequest address;

    private List<RegisterStoreTimeRequest> storeTimeList;
    /**
     * 원산지
     * COS 라고도 불림.
     */
    private String certificateOfAnalysis;

    public ModifyStoreCommand convertCommand() {
        ModifyStoreCommand modifyStoreCommand = new ModifyStoreCommand();
        copyProperties(this, modifyStoreCommand);
        modifyStoreCommand.setAddress(address.mapToDomain());
        return modifyStoreCommand;
    }

}
