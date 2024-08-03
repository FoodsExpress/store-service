package com.foodexpress.storeservice.adapter.in.web.search;

import lombok.Data;

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
