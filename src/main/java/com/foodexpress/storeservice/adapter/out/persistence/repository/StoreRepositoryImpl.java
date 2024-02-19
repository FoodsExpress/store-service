package com.foodexpress.storeservice.adapter.out.persistence.repository;

import com.foodexpress.storeservice.adapter.out.persistence.Querydsl5Support;
import com.foodexpress.storeservice.adapter.out.persistence.StoreDto;
import com.foodexpress.storeservice.adapter.out.persistence.StoreEntity;
import com.foodexpress.storeservice.adapter.out.persistence.StoreSearchCondition;
import com.foodexpress.storeservice.domain.store.Store;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

import static com.foodexpress.storeservice.adapter.out.persistence.QStoreEntity.storeEntity;
import static com.querydsl.core.types.Projections.fields;

public class StoreRepositoryImpl extends Querydsl5Support implements StoreRepositoryQuerydsl {

    protected StoreRepositoryImpl() {
        super(StoreEntity.class);
    }

    @Override
    public List<Store> findAllBySearchCondition(StoreSearchCondition searchCondition, Pageable pageable) {

        List<StoreDto> storeDtoList = select(fields(StoreDto.class,
                                                    storeEntity.bizNo,
                                                    storeEntity.storeId,
                                                    storeEntity.storeUserId,
                                                    storeEntity.franchiseId,
                                                    storeEntity.storeType,
                                                    storeEntity.storeName,
                                                    storeEntity.storeStatus,
                                                    storeEntity.startedAt,
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
                StringUtils.isNotEmpty(searchCondition.getBizNo()) ? storeEntity.bizNo.eq(searchCondition.getBizNo()) : null,
                StringUtils.isNotEmpty(searchCondition.getStoreName()) ? storeEntity.storeName.contains(searchCondition.getStoreName()) :
                    null
            ).fetch();
        return storeDtoList.stream().map(StoreDto::mapToDomain).collect(Collectors.toList());
    }

}
