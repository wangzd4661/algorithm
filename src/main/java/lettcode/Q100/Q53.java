package lettcode.Q100;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/comments/
 */
public class Q53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.printf("" + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int ans = 0, maxn = Integer.MIN_VALUE;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(ans < 0) ans = 0;  //如果前面的和小0，那么重新开始求和
            ans += nums[i];
            maxn = Math.max(maxn, ans);
        }
        return maxn;
    }
}
