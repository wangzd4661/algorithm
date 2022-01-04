package lettcode.Q100;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Q198 {
    public static void main(String[] args) {
        int[] n = {2, 7, 9,3, 1};
        System.out.printf("" + rob2(n));
    }

    /**
     * 选f(i)  --- int a=f(i-2)+arr[i]
     * 不选f(i) -- int b=f(i-1)
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(result[i - 2] + nums[i], result[i - 1]);
        }
        return result[nums.length - 1];
    }
    //f(n)=max(cost[n]+f(n-2),f(n-1))
    public static int rob2(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int pre=0;
        int cur=nums[0];
        for (int i = 1; i <n; i++) {
            int max=Math.max(pre+nums[i],cur);
            pre=cur;
            cur=max;
        }
        return cur;
    }
}
