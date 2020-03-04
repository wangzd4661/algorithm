package lettcode.Q001;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Q1 {
    public static void main(String[] args) {
        int s[] = {2, 7, 11, 15};
        System.out.println(twoSum(s,9));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] value = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int v = target - nums[i];
                if (v == nums[j]) {
                    value[0] = i;
                    value[1] = j;
                    return value;
                }
            }
        }
        return value;
    }
}
