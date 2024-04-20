package com.foodexpress.storeservice.adapter.out.persistence.repository;

import com.foodexpress.storeservice.adapter.out.persistence.Querydsl5Support;
import com.foodexpress.storeservice.adapter.out.persistence.StoreDto;
import com.foodexpress.storeservice.adapter.out.persistence.StoreSearchCondition;
import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreEntity;
import com.foodexpress.storeservice.domain.store.Store;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;

import static com.foodexpress.storeservice.adapter.out.persistence.entity.QStoreEntity.storeEntity;
import static com.querydsl.core.types.Projections.fields;

public class StoreRepositoryImpl extends Querydsl5Support implements StoreRepositoryQuerydsl {

    protected StoreRepositoryImpl() {
        super(StoreEntity.class);
    }

    @Override
    public Slice<Store> findAllBySearchCondition(StoreSearchCondition searchCondition, Pageable pageable) {
        List<StoreDto> storeDtoList = select(fields(StoreDto.class,
                                                    storeEntity.id,
                                                    storeEntity.bizNo,
                                                    storeEntity.storeId,
                                                    storeEntity.storeUserId,
                                                    storeEntity.franchiseId,
                                                    storeEntity.storeType,
                                                    storeEntity.storeName,
                                                    storeEntity.storeStatus,
                                                    storeEntity.startedAt,
                                                    storeEntity.ratings,
                                                    storeEntity.ratingsCount,
                                                    storeEntity.deliveryMinTime,
                                                    storeEntity.deliveryMaxTime,
                                                    storeEntity.deliveryMinFee,
                                                    storeEntity.deliveryMaxFee,
                                                    storeEntity.address.zonecode,
                                                    storeEntity.address.address,
                                                    storeEntity.address.addressEnglish,
                                                    storeEntity.address.addressType,
                                                    storeEntity.address.userSelectedType,
                                                    storeEntity.address.roadAddress,
                                                    storeEntity.address.jibunAddress,
                                                    storeEntity.address.buildingCode,
                                                    storeEntity.address.buildingName,
                                                    storeEntity.address.apartment,
                                                    storeEntity.address.sido,
                                                    storeEntity.address.sigungu,
                                                    storeEntity.address.sigunguCode,
                                                    storeEntity.address.roadnameCode,
                                                    storeEntity.address.bcode,
                                                    storeEntity.address.bname
        )).from(storeEntity)
            .where(
                whereStoreQuery(searchCondition),
                eqCursorId(searchCondition.getId())
            ).limit(pageable.getPageSize() + 1L)
            .orderBy(storeEntity.id.desc())
            .fetch();
        boolean hasNext = false;

        if (storeDtoList.size() > pageable.getPageSize()) {
            storeDtoList.remove(pageable.getPageSize());
            hasNext = true;
        }
        List<Store> stores = storeDtoList.stream().map(StoreDto::mapToDomain).toList();
        return new SliceImpl<>(stores, pageable, hasNext);
    }

    private BooleanBuilder whereStoreQuery(StoreSearchCondition searchCondition) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        return booleanBuilder
            .and(StringUtils.isNotEmpty(searchCondition.getBizNo()) ? storeEntity.bizNo.eq(searchCondition.getBizNo()) : null)
            .and(StringUtils.isNotEmpty(searchCondition.getStoreName()) ? storeEntity.storeName.contains(searchCondition.getStoreName()) :
                     null);
    }

    private BooleanExpression eqCursorId(Long cursorId) { // (7)
        if (cursorId != null) {
            return storeEntity.id.lt(cursorId);
        }
        return null;
    }

}
