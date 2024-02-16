package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.domain.address.Address;
import com.foodexpress.storeservice.domain.store.BizNo;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.store.StoreStatus;
import com.foodexpress.storeservice.domain.store.StoreType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class StoreEntity extends UpdatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 사업자 등록번호
     */
    @Column(unique = true)
    private String bizNo;

    /**
     * 점주 식별자
     */
    private String storeUserId;

    /**
     * 프랜차이즈 식별자
     */
    private String franchiseId;

    private String storeId;

    /**
     * <p>상점 유형</p>
     * 법인, 개인사업자 등
     */
    private StoreType storeType;

    /**
     * 가게 이름
     */
    private String storeName;

    /**
     * <p>가게 상태</p>
     * 심사중, 거절, 승인, 정상, 휴점, 폐점
     */
    private StoreStatus storeStatus;

    /**
     * 상점 시작 일자
     */
    private LocalDate startedAt;

    @Embedded
    private Address address;

    public static StoreEntity mapToEntity(Store store) {
        StoreEntity entity = new StoreEntity();
        entity.storeId = UUID.randomUUID().toString();
        entity.bizNo = store.bizNo().getBizNumber();
        entity.storeUserId = store.storeUserId();
        entity.franchiseId = store.franchiseId();
        entity.storeType = store.storeType();
        entity.storeName = store.storeName();
        entity.startedAt = store.startedAt();
        entity.address = store.address();
        return entity;
    }

    public static StoreEntity of(String storeId) {
        StoreEntity entity = new StoreEntity();
        entity.id = Long.parseLong(storeId);
        return entity;
    }

    public Store mapToDomain() {
        return Store.builder()
            .storeId(storeId)
            .bizNo(BizNo.create(bizNo))
            .storeUserId(storeUserId)
            .franchiseId(franchiseId)
            .storeType(storeType)
            .storeName(storeName)
            .startedAt(startedAt)
            .address(address)
            .build();
    }

}
