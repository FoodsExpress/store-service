package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.domain.storetime.StoreTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ModifyStoreTimeResponse {

    private List<StoreTime> storeTimeList;

    public static ModifyStoreTimeResponse of(List<StoreTime> storeTimeList) {
        return new ModifyStoreTimeResponse(storeTimeList);
    }
}
