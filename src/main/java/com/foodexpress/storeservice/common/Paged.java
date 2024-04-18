package com.foodexpress.storeservice.common;

import java.util.List;

public record Paged<T>(PageMeta meta, List<T> data) {

}
