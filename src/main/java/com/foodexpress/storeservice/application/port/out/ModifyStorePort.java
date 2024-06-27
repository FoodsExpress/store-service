package com.foodexpress.storeservice.application.port.out;

import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import java.util.List;

public interface ModifyStorePort {

    Store modifyStore(Store store);

    List<StoreTime> modifyStoreTimes(String storeId, List<StoreTime> storeTimes);
}

