package com.foodexpress.storeservice.adapter.in.web.search;

import com.foodexpress.storeservice.application.port.in.SearchStoreQuery;
import lombok.Data;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class SearchStoreRequest {

    private String storeName;

    private String bizNo;

    private boolean use;

    private Long id;

    private int page;

    private int size;

    public SearchStoreQuery convertQuery() {
        SearchStoreQuery searchStoreQuery = new SearchStoreQuery();
        copyProperties(this, searchStoreQuery);
        return searchStoreQuery;
    }

}
