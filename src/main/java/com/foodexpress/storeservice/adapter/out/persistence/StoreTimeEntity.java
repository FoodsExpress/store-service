package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.domain.storetime.DayOfWeek;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import com.foodexpress.storeservice.domain.storetime.TimeType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class StoreTimeEntity extends UpdatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeTimeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId")
    private StoreEntity store;

    private TimeType timeType;

    private String startTime;

    private String endTime;

    private DayOfWeek dayOfWeek;

    public static StoreTimeEntity mapToEntity(StoreTime storeTime) {
        StoreTimeEntity entity = new StoreTimeEntity();
        entity.store = StoreEntity.of(storeTime.storeId());
        entity.storeTimeId = UUID.randomUUID().toString();
        entity.timeType = storeTime.timeType();
        entity.startTime = storeTime.startTime();
        entity.endTime = storeTime.endTime();
        entity.dayOfWeek = storeTime.dayOfWeek();
        return entity;
    }

    public StoreTime mapToDomain() {
        return StoreTime.builder()
            .storeTimeId(storeTimeId)
            .storeId(store.getStoreId())
            .timeType(timeType)
            .startTime(startTime)
            .endTime(endTime)
            .dayOfWeek(dayOfWeek)
            .build();
    }

}
