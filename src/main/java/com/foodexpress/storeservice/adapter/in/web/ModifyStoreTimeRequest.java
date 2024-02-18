package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.domain.storetime.DayOfWeek;
import com.foodexpress.storeservice.domain.storetime.TimeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ModifyStoreTimeRequest {

    private String storeTimeId;

    private TimeType timeType;

    private String startTime;

    private String endTime;

    private DayOfWeek dayOfWeek;
    
}
