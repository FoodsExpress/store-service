package com.foodexpress.storeservice.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foodexpress.storeservice.application.port.in.SearchStoreQuery;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class SearchStoreRequest {

    private String storeName;

    private String bizNo;

    @JsonProperty("isUse")
    private boolean use;

    public SearchStoreQuery convertQuery() {
        SearchStoreQuery searchStoreQuery = new SearchStoreQuery();
        copyProperties(this, searchStoreQuery);
        return searchStoreQuery;
    }

}
