package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.domain.address.Address;
import com.foodexpress.storeservice.domain.address.AddressType;
import lombok.Data;

@Data
public class RegisterAddressRequest {

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

    public Address mapToDomain() {
        return Address.builder()
            .zonecode(zonecode)
            .address(address)
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
    }

}
