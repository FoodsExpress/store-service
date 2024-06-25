package com.foodexpress.storeservice.application.port.in.command;

import com.foodexpress.storeservice.common.SelfValidating;
import com.foodexpress.storeservice.domain.address.Address;
import com.foodexpress.storeservice.domain.store.BizNo;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.store.StoreStatus;
import com.foodexpress.storeservice.domain.store.StoreType;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RegisterStoreCommand extends SelfValidating<RegisterStoreCommand> {

    /**
     * 사업자 등록번호
     */
    @NotNull
    private String bizNo;

    /**
     * 점주 식별자
     */
    @NotNull
    private String storeUserId;

    /**
     * 프랜차이즈 식별자
     */
    private String franchiseId;

    /**
     * <p>상점 유형</p>
     * 법인, 개인사업자 등
     */
    @NotNull
    private StoreType storeType;

    /**
     * 가게 이름
     */
    @NotNull
    private String storeName;

    /**
     * 상점 시작 일자
     */
    private LocalDate startedAt;

    /**
     * 주소
     */
    @NotNull
    private Address address;

    /**
     * 원산지
     * COS 라고도 불림.
     */
    private String certificateOfAnalysis;

    private List<StoreTime> storeTimeList;

    public Store mapToDomain() {
        this.validateSelf();
        return Store.builder()
            .bizNo(BizNo.create(this.bizNo))
            .storeUserId(storeUserId)
            .franchiseId(franchiseId)
            .storeType(storeType)
            .storeName(storeName)
            .storeStatus(StoreStatus.PENDING)
            .startedAt(startedAt)
            .address(address)
            .certificateOfAnalysis(certificateOfAnalysis)
            .storeTimeList(storeTimeList)
            .build();
    }

}
