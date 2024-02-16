package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.application.port.in.RegisterStoreTimeCommand;
import com.foodexpress.storeservice.domain.storetime.DayOfWeek;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import com.foodexpress.storeservice.domain.storetime.TimeType;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static org.springframework.beans.BeanUtils.copyProperties;

@ToString
@EqualsAndHashCode
public class RegisterStoreTimeRequest {

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
        return StoreTime.builder()
            .timeType(timeType)
            .startTime(startTime)
            .endTime(endTime)
            .dayOfWeek(dayOfWeek)
            .build();
    }

    public RegisterStoreTimeCommand mapToCommand(Long id) {
        RegisterStoreTimeCommand command = new RegisterStoreTimeCommand();
        copyProperties(this, command);
        command.setStoreId(id);
        return command;
    }

}
