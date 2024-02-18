package com.foodexpress.storeservice.adapter.in.web;

import static org.springframework.beans.BeanUtils.copyProperties;

import com.foodexpress.storeservice.application.port.in.ModifyStoreTimesCommand;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ModifyStoreTimesRequest {

    private String storeId;

    List<ModifyStoreTimeRequest> modifyStoreTimeRequestList;

    public ModifyStoreTimesCommand convertCommand() {
        ModifyStoreTimesCommand modifyStoreTimesCommand = new ModifyStoreTimesCommand();
        copyProperties(this, modifyStoreTimesCommand);
        return modifyStoreTimesCommand;
    }
}
