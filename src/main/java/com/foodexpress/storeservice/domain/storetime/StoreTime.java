package com.foodexpress.storeservice.domain.storetime;

import lombok.Builder;

/**
 * 가게 시간 도메인
 *
 * @author seunggu.lee
 */
@Builder
public record StoreTime(String storeTimeId, String storeId, TimeType timeType, String startTime, String endTime, DayOfWeek dayOfWeek) {

}
