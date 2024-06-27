package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.domain.address.Address;
import com.foodexpress.storeservice.domain.address.AddressType;
import com.foodexpress.storeservice.domain.store.BizNo;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.store.StoreStatus;
import com.foodexpress.storeservice.domain.store.StoreType;
import lombok.Setter;

import java.time.LocalDate;

@Setter
public class StoreDto {

    private Long id;

    private String bizNo;

    /**
     * 점주 식별자
     */
    private String storeUserId;

    /**
     * 프랜차이즈 식별자
     */
    private String franchiseId;

    private String storeId;

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
     * 평점
     */
    private double ratings;
    /**
     * 평점 숫자
     */
    private int ratingsCount;
    /**
     * 배달 예상 최소시간
     */
    private int deliveryMinTime;
    /**
     * 배달 예상 최대시간
     */
    private int deliveryMaxTime;
    /**
     * 배달 최소 비용
     */
    private int deliveryMinFee;
    /**
     * 배달 최대 비용
     */
    private int deliveryMaxFee;

    /**
     * 우편번호
     */
    private String zonecode;

    /**
     * 기본 주소
     */
    private String address;

    private String addressEnglish;

    /**
     * 검색된 기본 주소 타입: R(도로명), J(지번)
     */
    private AddressType addressType;

    /**
     * 검색 결과에서 사용자가 선택한 주소의 타입
     */
    private AddressType userSelectedType;

    /**
     * 도로명 주소
     */
    private String roadAddress;

    /**
     * 지번 주소
     */
    private String jibunAddress;

    /**
     * 건물관리번호
     */
    private String buildingCode;

    /**
     * 건물명
     */
    private String buildingName;

    /**
     * 공동주택 여부
     * (아파트,연립주택,다세대주택 등)
     * Y/N
     */
    private String apartment;

    /**
     * 도/시 이름
     */
    private String sido;

    /**
     * 시/군/구 이름
     */
    private String sigungu;

    /**
     * 시/군/구 코드
     * (5자리 구성된 시/군/구 코드입니다.)
     */
    private String sigunguCode;

    /**
     * 도로명 코드, 7자리로 구성된 도로명 코드입니다. 추후 7자리 이상으로 늘어날 수 있습니다.
     */
    private String roadnameCode;

    /**
     * 법정동/법정리 코드s
     */
    private String bcode;

    /**
     * 법정동/법정리 이름
     */
    private String bname;

    public Store mapToDomain() {
        Address addressField = Address.builder()
            .zonecode(zonecode)
            .address(this.address)
            .addressEnglish(addressEnglish)
            .addressType(addressType)
            .userSelectedType(userSelectedType)
            .roadAddress(roadAddress)
            .jibunAddress(jibunAddress)
            .buildingCode(buildingCode)
            .buildingName(buildingName)
            .apartment(apartment)
            .sido(sido)
            .sigungu(sigungu)
            .sigunguCode(sigunguCode)
            .roadnameCode(roadnameCode)
            .bcode(bcode)
            .bname(bname)
            .build();
        return Store.builder()
            .id(id)
            .storeId(storeId)
            .bizNo(BizNo.create(bizNo))
            .storeUserId(storeUserId)
            .franchiseId(franchiseId)
            .storeType(storeType)
            .storeName(storeName)
            .storeStatus(storeStatus)
            .startedAt(startedAt)
            .ratings(ratings)
            .ratingsCount(ratingsCount)
            .deliveryMinTime(deliveryMinTime)
            .deliveryMaxTime(deliveryMaxTime)
            .deliveryMinFee(deliveryMinFee)
            .deliveryMaxFee(deliveryMaxFee)
            .address(addressField)
            .build();
    }

}
