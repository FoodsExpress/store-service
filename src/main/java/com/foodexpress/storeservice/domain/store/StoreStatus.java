package com.foodexpress.storeservice.domain.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 가게 상태
 *
 * @author seunggu.lee
 */
@Getter
@AllArgsConstructor
public enum StoreStatus {

    /**
     * <p>대기</p>
     * 가게가 가입신청 이후 심사를 거치는 상태
     */
    PENDING("대기"),
    /**
     * <p>거절</p>
     * 심사중 어떤 이유로 거절이 된 상태
     */
    REJECT("거절"),
    /**
     * <p>승인</p>
     * 심사를 거친 이후 가게가 승인된 상태.
     * 구독중인 상태일때 정상 상태로 변경된다. ( 금액 지불 )
     */
    APPROVED("승인"),
    /**
     * <p>정상</p>
     * 가게가 정상적으로 운영중인 상태
     */
    NORMAL("정상"),

    /**
     * <p>휴점</p>
     * 어떤 사정으로 인해 가게가 잠시 운영을 중단한 상태
     */
    CLOSING("휴점"),
    /**
     * <p>폐점</p>
     * 영업을 그만두거나 망해서 가게가 더 이상 운영되지 않는 상태
     */
    CLOSURE("폐점"),
    /**
     * <p>심사중</p>
     * 상점이 생성되었거나 정보 변경을 원하는 경우의 상태
     */
    UNDER_REVIEW("심사중");

    private final String statusName;
    
}
