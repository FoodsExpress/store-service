package com.foodexpress.storeservice.adapter.out.persistence.repository;

import com.foodexpress.storeservice.adapter.out.persistence.Querydsl5Support;
import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreEntity;

/**
 * 상점 Querydsl 구현용 레퍼지토리
 *
 * @author seunggu.lee
 */
public class StoreRepositoryImpl extends Querydsl5Support implements StoreRepositoryQuerydsl {

    protected StoreRepositoryImpl() {
        super(StoreEntity.class);
    }

}
