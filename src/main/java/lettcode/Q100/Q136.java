package lettcode.Q100;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/comments/
 */
public class Q136 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 2};
        System.out.print(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }
}
