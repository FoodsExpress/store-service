package com.foodexpress.storeservice.common;

import java.util.List;

public record Paged<T>(boolean hasMore, List<T> data) {

}
