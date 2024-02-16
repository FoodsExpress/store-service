package com.foodexpress.storeservice.domain.store;

import com.foodexpress.storeservice.domain.address.Address;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

/**
 * 상점 도메인
 *
 * @author seunggu.lee
 */
@Builder
public record Store(Long id, String storeId, BizNo bizNo, String storeUserId, String franchiseId, StoreType storeType, String storeName,
                    StoreStatus storeStatus,
                    LocalDate startedAt, Address address, String certificateOfAnalysis, List<StoreTime> storeTimeList) {

}
