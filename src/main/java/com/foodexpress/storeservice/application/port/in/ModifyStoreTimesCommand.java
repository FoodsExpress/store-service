package com.foodexpress.storeservice.application.port.in;

import com.foodexpress.storeservice.domain.storetime.StoreTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModifyStoreTimesCommand {

    private String storeId;

    private String storeUserId;

    private List<ModifyStoreTimeCommand> storeTimeList;

    public List<StoreTime> mapToDomain() {
        return storeTimeList.stream()
                            .map(storeTime -> StoreTime.builder()
                                                       .storeTimeId(storeTime.getStoreTimeId())
                                                       .storeId(storeId)
                                                       .timeType(storeTime.getTimeType())
                                                       .startTime(storeTime.getStartTime())
                                                       .endTime(storeTime.getEndTime())
                                                       .dayOfWeek(storeTime.getDayOfWeek())
                                                       .build())
                            .toList();
    }
}
