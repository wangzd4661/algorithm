package lettcode.Q300;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class Q303 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Q303 q303 = new Q303(nums);
        System.out.printf("," + q303.sumRange(0, 2));
        System.out.printf("," + q303.sumRange(2, 5));
        System.out.printf("," + q303.sumRange(0, 5));

    }

    private int[] sum;

    public Q303(int[] nums) {
        if (nums == null || nums.length == 0) return;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null || sum.length == 0) return 0;
        if (i > 0) {
            return sum[j] - sum[i - 1];
        } else {
            return sum[j];
        }
    }
}
