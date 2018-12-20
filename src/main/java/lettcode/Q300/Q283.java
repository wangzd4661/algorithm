package lettcode.Q300;

import java.util.Arrays;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Q283 {
    public static void main(String[] args) {
        int[] n = {1, 0, 2, 0, 3, 1};
        new Q283().moveZeroes(n);
        System.out.printf("" + Arrays.toString(n));
    }

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {//可优化i==k时不换
                if (i != k) {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                }
                k++;
            }
        }
    }
}
