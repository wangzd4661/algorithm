package lettcode.Q001;

import java.util.Arrays;

/**
 * 80. 删除排序数组中的重复项 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Q80 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        int l = removeDuplicates(nums);
        System.out.println("" + l);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums==null||nums.length == 0) {
            return 0;
        }
        int count = 1;
        int cur=nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if(nums[i]!=cur){
                cur=nums[i];
                count=1;
            }else {
                count++;
                if(count>2){
                    
                }
            }
        }
        return 0;
    }
}
