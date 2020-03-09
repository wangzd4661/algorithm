package lettcode.Q300;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class Q347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Integer integer : map.keySet()) {
            queue.add(integer);
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.remove());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        List<Integer> list = topKFrequent(arr, 2);
        for (Integer o : list) {
            System.out.println(o);
        }

    }
}
