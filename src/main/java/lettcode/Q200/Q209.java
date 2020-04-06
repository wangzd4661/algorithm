package lettcode.Q200;

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Q209 {
    public static void main(String[] args) {
        System.out.printf("" + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null || nums.length == 0) return 0;
        int res = nums.length + 1;
        int left = 0, right = -1, sum = 0;
        while (left < nums.length) {
            if (right + 1 < nums.length && sum < s) {
                right++;
                sum = sum + nums[right];
            } else {
                sum = sum - nums[left];
                left++;
            }
            if (sum >= s)
                res = Math.min(res, right - left + 1);
        }
        if(res == nums.length + 1)
            return 0;
        return res;
    }
}
