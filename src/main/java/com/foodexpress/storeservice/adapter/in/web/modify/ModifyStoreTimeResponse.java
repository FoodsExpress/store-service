package com.foodexpress.storeservice.adapter.in.web.modify;

import com.foodexpress.storeservice.domain.storetime.StoreTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ModifyStoreTimeResponse {

    private List<StoreTime> storeTimeList;

    public static ModifyStoreTimeResponse of(List<StoreTime> storeTimeList) {
        return new ModifyStoreTimeResponse(storeTimeList);
    }

}
