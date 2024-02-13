package com.foodexpress.storeservice.domain.store;

import com.foodexpress.storeservice.domain.address.Address;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 상점 도메인
 *
 * @author seunggu.lee
 */
@Getter
@Builder
public class Store {

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

}
