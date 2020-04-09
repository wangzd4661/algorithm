package lettcode.Q900;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class Q977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
    }
    public static int[] sortedSquares(int[] A) {
        int[] res=new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i]=A[i]*A[i];
        }
        Arrays.sort(res);
        return res;
    }
}
