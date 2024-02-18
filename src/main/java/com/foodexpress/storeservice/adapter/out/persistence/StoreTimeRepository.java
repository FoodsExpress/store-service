package com.foodexpress.storeservice.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreTimeRepository extends JpaRepository<StoreTimeEntity, Long> {

    Optional<StoreTimeEntity> findByStoreTimeId(String storeTimeId);
}
