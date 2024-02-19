package com.foodexpress.storeservice.adapter.out.persistence;

import lombok.Data;

@Data
public class StoreSearchCondition {

    private String storeName;

    private String bizNo;

    private boolean use;

}
