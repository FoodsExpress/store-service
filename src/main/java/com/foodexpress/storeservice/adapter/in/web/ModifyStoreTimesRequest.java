package com.foodexpress.storeservice.adapter.in.web;

import com.foodexpress.storeservice.application.port.in.command.ModifyStoreTimesCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

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
