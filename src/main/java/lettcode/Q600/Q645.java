package lettcode.Q600;

import java.util.Arrays;

/**
 * 645. 错误的集合
 * https://leetcode-cn.com/problems/set-mismatch/
 */
public class Q645 {
    public static void main(String[] args) {
      int[] arr=  new Q645().findErrorNums(new int[]{1,2,2,4});
        System.out.printf(Arrays.toString(arr));
    }

    public int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length+1];
        freq[0]=-1;
        for (int num : nums) {
            freq[num]++;
        }
        int miss = 0;
        int repeat = 0;
        for (int i = 1; i < freq.length; i++) {
            int num=freq[i];
            if (num == 2) repeat = i;
            if (num == 0) miss = i;
        }
        return new int[]{repeat,miss};
    }

}
