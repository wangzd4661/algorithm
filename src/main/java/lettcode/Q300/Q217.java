package lettcode.Q300;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class Q217 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        containsDuplicate(num);
        System.out.printf(containsDuplicate(num) + "");
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
