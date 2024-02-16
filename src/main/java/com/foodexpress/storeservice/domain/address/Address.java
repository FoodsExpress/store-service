package com.foodexpress.storeservice.domain.address;

import lombok.Builder;

/**
 * 주소 도메인
 *
 * @author seunggu.lee
 */
@Builder
public record Address(String zonecode, String address, String addressEnglish, AddressType addressType, AddressType userSelectedType,
                      String roadAddress, String jibunAddress, String buildingCode, String buildingName, String apartment, String sido,
                      String sigungu, String sigunguCode, String roadnameCode, String bcode, String bname) {

}
