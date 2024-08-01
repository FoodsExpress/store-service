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

/**
 * 상점 Querydsl 구현용 레퍼지토리
 *
 * @author seunggu.lee
 */
public class StoreRepositoryImpl extends Querydsl5Support implements StoreRepositoryQuerydsl {

    protected StoreRepositoryImpl() {
        super(StoreEntity.class);
    }

    /**
     * 조회 조건에 따른 상점 목록 조회
     * Cursor Based Pagination 을 구현.
     *
     * @param searchCondition 검색 조건.
     * @param pageable        페이지 조건
     * @return Slice<Store>   페이징 처리된 결과 값
     */
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
                ltCursorId(searchCondition.getId())
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

    /**
     * 페이징 처리 기준 점 잡는 메서드
     * 해당 커서 아이디로부터 n 건을 조회하기 위해 기준점을 잡는다.
     * 만약 null 이라면 처음부터 조회.
     *
     * @param cursorId 기준이 될 커서 아이디
     */
    private BooleanExpression ltCursorId(Long cursorId) {
        if (cursorId != null) {
            return storeEntity.id.lt(cursorId);
        }
        return null;
    }

}
