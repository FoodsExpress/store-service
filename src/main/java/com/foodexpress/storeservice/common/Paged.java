package com.foodexpress.storeservice.common;

import java.util.List;

/**
 * 페이징 처리를 위한 객체
 * 해당 객체는 cursor paging 방식으로 항상 다음이 있는지 없는지 정보를 함께 넘긴다.
 *
 * @param hasMore 다음 조회할 내용이 있는지 여부
 * @param data    조회된 데이터 목록
 * @param <T>     조회할 데이터의 제네릭 타입
 * @author seunggu.lee
 */
public record Paged<T>(boolean hasMore, List<T> data) {

}
