package com.foodexpress.storeservice.domain.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 가게 유형
 */
@AllArgsConstructor
@Getter
public enum StoreType {
    /**
     * 개인 사업자
     */
    SOLE_PROPRIETOR("개인 사업자"),
    /**
     * 법인
     */
    CORPORATION("법인"),
    ;

    private final String storeTypeName;

}
