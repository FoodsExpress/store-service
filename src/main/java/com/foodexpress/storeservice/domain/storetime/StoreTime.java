package com.foodexpress.storeservice.domain.storetime;

import lombok.Builder;
import lombok.Getter;

/**
 * 가게 시간 도메인
 *
 * @author seunggu.lee
 */
@Getter
@Builder
public class StoreTime {

    /**
     * 가게 시간 식별자
     */
    private String storeTimeId;

    /**
     * 가게 식별자
     */
    private String storeId;

    /**
     * 시간 종류
     */
    private TimeType timeType;

    /**
     * 시작 시간
     */
    private String startTime;

    /**
     * 종료 시간
     */
    private String endTime;

    /**
     * 요일
     */
    private DayOfWeek dayOfWeek;

}
