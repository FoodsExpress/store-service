package com.foodexpress.storeservice.adapter.in.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodexpress.storeservice.common.annotations.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

@KafkaConsumer
@RequiredArgsConstructor
public class ExamineStoreConsumer {

    private final ObjectMapper objectMapper;
    private final ExamineStoreUseCase examineStoreUsecase;

    @KafkaListener(topics = "${kafka.examine-store}")
    public void examineConsumer(String kafkaMessage) {
        try {
            ExamineStoreRequest request = objectMapper.readValue(kafkaMessage, ExamineStoreRequest.class);
            examineStoreUsecase.examine(request.mapToCommand());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
