package com.foodexpress.storeservice.adapter.out.persistence;

import com.foodexpress.storeservice.adapter.out.persistence.entity.StoreTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreTimeRepository extends JpaRepository<StoreTimeEntity, Long> {

    Optional<StoreTimeEntity> findByStoreTimeId(String storeTimeId);

}
