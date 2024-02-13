package com.foodexpress.storeservice.domain.store;

/**
 * 가게 상태
 *
 * @author seunggu.lee
 */
public enum StoreStatus {

    /**
     * <p>대기</p>
     * 가게가 가입신청 이후 심사를 거치는 상태
     */
    PENDING,
    /**
     * <p>거절</p>
     * 심사중 어떤 이유로 거절이 된 상태
     */
    REJECT,
    /**
     * <p>승인</p>
     * 심사를 거친 이후 가게가 승인된 상태.
     * 구독중인 상태일때 정상 상태로 변경된다. ( 금액 지불 )
     */
    APPROVED,
    /**
     * <p>정상</p>
     * 가게가 정상적으로 운영중인 상태
     */
    NORMAL,

    /**
     * <p>휴점</p>
     * 어떤 사정으로 인해 가게가 잠시 운영을 중단한 상태
     */
    CLOSING,
    /**
     * <p>폐점</p>
     * 영업을 그만두거나 망해서 가게가 더 이상 운영되지 않는 상태
     */
    CLOSURE,
}
