package com.foodexpress.storeservice.adapter.out.persistence.entity;

import com.foodexpress.storeservice.domain.store.BizNo;
import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.store.StoreStatus;
import com.foodexpress.storeservice.domain.store.StoreType;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@ToString
@Table(name = "store")
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
    @Enumerated(EnumType.STRING)
    private StoreType storeType;

    /**
     * 가게 이름
     */
    private String storeName;

    /**
     * <p>가게 상태</p>
     * 심사중, 거절, 승인, 정상, 휴점, 폐점
     */
    @Enumerated(EnumType.STRING)
    private StoreStatus storeStatus;

    /**
     * 상점 시작 일자
     */
    private LocalDate startedAt;

    @Embedded
    private AddressEntity address;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private Set<StoreTimeEntity> storeTimeList = new HashSet<>();

    public static StoreEntity mapToEntity(Store store) {
        StoreEntity entity = new StoreEntity();
        entity.storeId = UUID.randomUUID()
            .toString();
        entity.bizNo = store.bizNo()
            .getBizNumber();
        entity.storeUserId = store.storeUserId();
        entity.franchiseId = store.franchiseId();
        entity.storeType = store.storeType();
        entity.storeName = store.storeName();
        entity.startedAt = store.startedAt();
        entity.storeStatus = store.storeStatus();
        entity.address = AddressEntity.mapToEntity(store.address());
        if (StringUtils.isNotEmpty(store.updatedBy())) {
            entity.updatedBy = store.updatedBy();
        }
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
            .storeStatus(storeStatus)
            .startedAt(startedAt)
            .address(address.mapToDomain())
            .createdDate(createdDate)
            .createdBy(createdBy)
            .updatedBy(updatedBy)
            .updatedDate(updatedDate)
            .build();
    }

    public void modify(Store store) {
        this.storeName = store.storeName();
        this.storeType = store.storeType();
        this.address = AddressEntity.mapToEntity(store.address());
        this.storeStatus = StoreStatus.UNDER_REVIEW;
    }

    public List<StoreTime> storeTimeListToDomain() {
        return this.storeTimeList.stream()
            .map(storeTime -> StoreTime.builder()
                .storeTimeId(storeTime.getStoreTimeId())
                .startTime(storeTime.getStartTime())
                .endTime(storeTime.getEndTime())
                .timeType(storeTime.getTimeType())
                .dayOfWeek(storeTime.getDayOfWeek())
                .build())
            .toList();
    }

}
