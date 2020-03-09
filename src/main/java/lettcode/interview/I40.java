package lettcode.interview;

import java.util.PriorityQueue;

/**
 * 面试题40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class I40 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null) return null;
        if (arr.length == 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length);
        for (int i : arr) {
            queue.add(i);
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.remove();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 4};
        int[] ret = getLeastNumbers(arr, 3);
        for (int i : ret) {
            System.out.println(i + "");
        }

    }
}
