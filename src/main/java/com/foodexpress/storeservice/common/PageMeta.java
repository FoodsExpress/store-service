package com.foodexpress.storeservice.common;

import lombok.Getter;

@Getter
public class PageMeta {

    private boolean hasMore;

    public static PageMeta of(boolean hasMore) {
        PageMeta pageMeta = new PageMeta();
        pageMeta.hasMore = hasMore;
        return pageMeta;
    }

}
