package com.foodexpress.storeservice.application.port.in;

import com.foodexpress.storeservice.domain.address.Address;
import com.foodexpress.storeservice.domain.store.BizNo;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.store.StoreStatus;
import com.foodexpress.storeservice.domain.store.StoreType;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RegisterStoreCommand {

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
    private Address address;

    /**
     * 원산지
     * COS 라고도 불림.
     */
    private String certificateOfAnalysis;

    private List<StoreTime> storeTimeList;

    public Store mapToDomain() {
        return Store.builder()
            .bizNo(bizNo)
            .storeUserId(storeUserId)
            .franchiseId(franchiseId)
            .storeType(storeType)
            .storeName(storeName)
            .storeStatus(storeStatus)
            .startedAt(startedAt)
            .address(address)
            .certificateOfAnalysis(certificateOfAnalysis)
            .storeTimeList(storeTimeList)
            .build();
    }

}
