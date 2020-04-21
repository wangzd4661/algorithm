package lettcode.Q001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class Q15 {
    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        if (map.get(0) >= 3) {
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(0);
            inner.add(0);
            inner.add(0);
            list.add(inner);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] * 2 + nums[j] == 0 && map.get(nums[i]) >= 2) {
                    ArrayList<Integer> inner = new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[i]);
                    inner.add(nums[j]);
                    list.add(inner);
                }
                if (nums[i] + nums[j] * 2 == 0 && map.get(nums[j]) >= 2) {
                    ArrayList<Integer> inner = new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[j]);
                    inner.add(nums[j]);
                    list.add(inner);
                }
                int c = 0 - nums[i] - nums[j];
                if (c > nums[j] && map.containsKey(c)) {
                    ArrayList<Integer> inner = new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[j]);
                    inner.add(c);
                    list.add(inner);
                }
            }
        }
        System.out.printf(""+list.toString());
        return list;
    }

}
