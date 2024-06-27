package com.foodexpress.storeservice.application.port.in.command;

import com.foodexpress.storeservice.common.SelfValidating;
import com.foodexpress.storeservice.domain.storetime.DayOfWeek;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import com.foodexpress.storeservice.domain.storetime.TimeType;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class RegisterStoreTimeCommand extends SelfValidating<RegisterStoreTimeCommand> {

    private Long storeId;

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

    public StoreTime mapToDomain() {
        this.validateSelf();
        return StoreTime.builder()
            .storeId(Long.toString(storeId))
            .timeType(timeType)
            .startTime(startTime)
            .endTime(endTime)
            .dayOfWeek(dayOfWeek)
            .build();
    }

}
