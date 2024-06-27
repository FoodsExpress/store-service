package com.foodexpress.storeservice.application.port.in.command;

import com.foodexpress.storeservice.domain.storetime.DayOfWeek;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import com.foodexpress.storeservice.domain.storetime.TimeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModifyStoreTimeCommand {

    private String storeTimeId;

    private TimeType timeType;

    private String startTime;

    private String endTime;

    private DayOfWeek dayOfWeek;

    public StoreTime mapToDomain() {
        return StoreTime.builder()
            .storeTimeId(storeTimeId)
            .timeType(timeType)
            .startTime(startTime)
            .endTime(endTime)
            .build();
    }

}
