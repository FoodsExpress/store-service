package com.foodexpress.storeservice.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("kafka.config")
public class KafkaConfigProperties {

    private String bootstrapServersConfig;
    private String groupIdConfig;

}
