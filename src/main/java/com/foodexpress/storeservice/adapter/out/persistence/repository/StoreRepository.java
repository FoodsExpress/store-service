package com.foodexpress.storeservice.adapter.out.persistence.repository;

import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreEntity, Long>, StoreRepositoryQuerydsl {

    Optional<StoreEntity> findByStoreId(String storeId);

    boolean existsByBizNo(String bizNumber);

}
