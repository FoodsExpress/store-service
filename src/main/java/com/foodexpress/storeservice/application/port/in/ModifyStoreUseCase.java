package com.foodexpress.storeservice.application.port.in;

import com.foodexpress.storeservice.domain.store.Store;
import com.foodexpress.storeservice.domain.storetime.StoreTime;
import java.util.List;

public interface ModifyStoreUseCase {

    Store modifyStore(ModifyStoreCommand modifyStoreCommand);

    List<StoreTime> modifyStoreTime(ModifyStoreTimesCommand modifyStoreTimeCommand);
}
