package lettcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/5/24.
 * 加一
 */
public class Test14 {
    public static void main(String[] args) {
        int[] n = {1,9, 9};
        System.out.print(Arrays.toString(plusOne(n)));
    }

    public static int[] plusOne(int[] digits) {
        int sum = ++digits[digits.length - 1];
        if (sum == 10) {
            int[] result = new int[digits.length + 1];
            int carry = 1;
            digits[digits.length - 1] = 0;
            for (int i = digits.length - 2; i >= 0; i--) {
                if (carry != 0) {
                    digits[i] = digits[i] + carry;
                    carry = digits[i] / 10;
                    digits[i] = digits[i] % 10;
                } else {
                    return digits;
                }
            }
            if (digits[0] == 0) {
                result[0] = 1;
                return result;
            }else {
                return digits;
            }
        } else {
            return digits;
        }
    }
}
