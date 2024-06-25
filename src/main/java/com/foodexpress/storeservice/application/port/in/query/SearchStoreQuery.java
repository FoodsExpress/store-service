package com.foodexpress.storeservice.application.port.in.query;

import com.foodexpress.storeservice.adapter.out.persistence.StoreSearchCondition;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class SearchStoreQuery {

    private String storeName;

    private String bizNo;

    private boolean use;

    private Long id;

    private int page;

    private int size;

    public StoreSearchCondition convertCondition() {
        StoreSearchCondition condition = new StoreSearchCondition();
        copyProperties(this, condition);
        return condition;
    }

}
