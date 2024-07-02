package com.foodexpress.storeservice.domain.store;

import com.foodexpress.storeservice.common.exceptions.NotValidBusinessNumberException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 사업자 번호
 *
 * @author seunggu.lee
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BizNo {

    private String bizNumber;

    public static BizNo create(String bizNumber) {
        if (!isValidBusinessNumber(bizNumber)) {
            throw new NotValidBusinessNumberException("유효하지 않은 사업자 번호 입니다.");
        }
        if (bizNumber.contains("-")) {
            bizNumber = bizNumber.replace("-", "");
        }
        return new BizNo(bizNumber);
    }

    public static boolean isValidBusinessNumber(String number) {
        if (number.length() != 10) {
            return false;
        }

        try {
            return checkBusinessNumber(number);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getSum(String number) {
        int sum = 0;

        int[] checkArray = {1, 3, 7, 1, 3, 7, 1, 3, 5};

        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(number.charAt(i)) * checkArray[i];
        }
        return sum;
    }

    private static boolean checkBusinessNumber(String number) {
        int sum = getSum(number);

        sum += (Character.getNumericValue(number.charAt(8)) * 5) / 10;
        return isValidNumber(number, sum);
    }

    private static boolean isValidNumber(String number, int sum) {
        return (10 - sum % 10) % 10 == Character.getNumericValue(number.charAt(9));
    }

}
