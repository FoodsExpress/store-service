package com.foodexpress.storeservice.application.service;

import com.foodexpress.storeservice.application.port.in.command.ExamineStoreCommand;
import com.foodexpress.storeservice.application.port.in.command.ExamineStoreUseCase;
import com.foodexpress.storeservice.application.port.out.ExamineStorePort;
import com.foodexpress.storeservice.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ExamineService implements ExamineStoreUseCase {

    private final ExamineStorePort examineStorePort;

    @Override
    public void examine(ExamineStoreCommand examineStoreCommand) {
        examineStorePort.examine(examineStoreCommand.mapToDomain());
    }

}
