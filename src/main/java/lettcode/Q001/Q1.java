package lettcode.Q001;

import java.util.HashMap;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Q1 {
    public static void main(String[] args) {
        int s[] = {11, 7, 2, 15};
        System.out.println(twoSum3(s, 9)[0]);
        System.out.println(twoSum3(s, 9)[1]);
    }

    //Time O(n^2) Space O(1) 双循环，小优化是根据题意j可以不从0而从i+1开始。
    public static int[] twoSum(int[] nums, int target) {
        int[] value = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
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

    //Time O(n) Space O(n) 空间换时间 一次循环2n
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = record.get(target - nums[i]);
            if (index != null && index != i) {
                int[] res = {i, index};
                return res;
            }
        }
        throw new IllegalArgumentException("the input has no solution");
    }

    //Time O(n) Space O(n) 一次循环
    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                int[] res = {i, record.get(complement)};
                return res;
            }
            record.put(nums[i], i);
        }
        throw new IllegalArgumentException("the input has no solution");
    }
}
