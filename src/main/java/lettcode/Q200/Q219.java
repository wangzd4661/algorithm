package lettcode.Q200;

import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
public class Q219 {
    public static void main(String[] args) {
        boolean t = new Q219().containsNearbyDuplicate(new int[]{1, 2, 3,4,5, 1}, 3);
        System.out.printf("" + t);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) return false;
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) return true;
            record.add(nums[i]);
            if (record.size() == k + 1)
                record.remove(nums[i - k]);
        }
        return false;
    }
}
