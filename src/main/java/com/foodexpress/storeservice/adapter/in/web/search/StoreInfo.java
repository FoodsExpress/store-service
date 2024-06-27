package com.foodexpress.storeservice.adapter.in.web.search;

import com.foodexpress.storeservice.domain.store.Store;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StoreInfo {

    private Long id;
    private String uuid;
    private String name;
    private String thumbUrl;
    private List<String> tags = new ArrayList<>();
    /**
     * 평점
     */
    private double ratings;
    /**
     * 평점 숫자
     */
    private int ratingsCount;
    /**
     * 배달 예상 최소시간
     */
    private int deliveryMinTime;
    /**
     * 배달 예상 최대시간
     */
    private int deliveryMaxTime;
    /**
     * 배달 최소 비용
     */
    private int deliveryMinFee;
    /**
     * 배달 최대 비용
     */
    private int deliveryMaxFee;

    public static StoreInfo from(Store store) {
        StoreInfo info = new StoreInfo();
        info.name = store.storeName();
        info.id = store.id();
        info.uuid = store.storeId();
        info.thumbUrl = "";
        info.ratings = store.ratings();
        info.ratingsCount = store.ratingsCount();
        info.deliveryMinTime = store.deliveryMinTime();
        info.deliveryMaxTime = store.deliveryMaxTime();
        info.deliveryMinFee = store.deliveryMinFee();
        info.deliveryMaxFee = store.deliveryMaxFee();
        return info;
    }

}
