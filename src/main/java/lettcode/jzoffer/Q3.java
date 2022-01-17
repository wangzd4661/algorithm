package lettcode.jzoffer;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public static void main(String[] args) {

    }

    //Space:O(n),Time:O(n)
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            boolean add = set.add(nums[i]);
            if (!add) return nums[i];
        }
        return -1;
    }
    //
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

}
