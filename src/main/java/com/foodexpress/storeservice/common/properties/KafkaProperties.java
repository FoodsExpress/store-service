package com.foodexpress.storeservice.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@ConfigurationProperties("kafka")
public class KafkaProperties {

    private String examineStore;

}
