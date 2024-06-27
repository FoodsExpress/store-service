package com.foodexpress.storeservice.adapter.out.persistence.entity;

import com.foodexpress.storeservice.domain.address.Address;
import com.foodexpress.storeservice.domain.address.AddressType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

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
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    /**
     * 검색 결과에서 사용자가 선택한 주소의 타입
     */
    @Enumerated(EnumType.STRING)
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

    public static AddressEntity mapToEntity(Address address) {
        return AddressEntity.builder()
            .zonecode(address.zonecode())
            .address(address.address())
            .addressEnglish(address.addressEnglish())
            .addressType(address.addressType())
            .userSelectedType(address.userSelectedType())
            .roadAddress(address.roadAddress())
            .jibunAddress(address.jibunAddress())
            .buildingCode(address.buildingCode())
            .buildingName(address.buildingName())
            .apartment(address.apartment())
            .sido(address.sido())
            .sigungu(address.sigungu())
            .sigunguCode(address.sigunguCode())
            .roadnameCode(address.roadnameCode())
            .bcode(address.bcode())
            .bname(address.bname())
            .build();
    }

    public Address mapToDomain() {
        return Address.builder()
            .zonecode(this.zonecode)
            .address(this.address)
            .addressEnglish(this.addressEnglish)
            .addressType(this.addressType)
            .userSelectedType(this.userSelectedType)
            .roadAddress(this.roadAddress)
            .jibunAddress(this.jibunAddress)
            .buildingCode(this.buildingCode)
            .buildingName(this.buildingName)
            .apartment(this.apartment)
            .sido(this.sido)
            .sigungu(this.sigungu)
            .sigunguCode(this.sigunguCode)
            .roadnameCode(this.roadnameCode)
            .bcode(this.bcode)
            .bname(this.bname)
            .build();
    }

}
