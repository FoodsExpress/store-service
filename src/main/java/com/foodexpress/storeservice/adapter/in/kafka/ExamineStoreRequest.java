package com.foodexpress.storeservice.adapter.in.kafka;

import com.foodexpress.storeservice.application.port.in.command.ExamineStoreCommand;
import com.foodexpress.storeservice.domain.store.StoreStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamineStoreRequest {

    private String storeId;

    private StoreStatus storeStatus;

    private String userId;

    private String examineReason;

    public ExamineStoreCommand mapToCommand() {
        ExamineStoreCommand command = new ExamineStoreCommand();
        copyProperties(this, command);
        return command;
    }

}