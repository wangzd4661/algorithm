package lettcode.interview;

import java.util.PriorityQueue;

/**
 * 最小K个数，同I40
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class I17_14 {
    public int[] smallestK(int[] arr, int k) {
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
}
