package lettcode.Q100;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Q189 {
    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 3);
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k % nums.length == 0) return;
        int count=0,start = 0, index = 0, value = nums[index];
        while (count!=nums.length){
            int next = (index + k) % nums.length;
            int temp = nums[next];
            nums[next]=value;
            value = temp;
            index = next;
            if (index == start) {
                start++;
                index = start;
                value = nums[index];
            }
            count++;
        }
        System.out.println("nums = " + Arrays.toString(nums) + ", k = " + k);
    }
}
