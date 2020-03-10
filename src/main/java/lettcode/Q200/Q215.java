package lettcode.Q200;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.add(num);
        }
        System.out.println(queue);
        int n = 0;
        for (int i = 0; i < k; i++) {
            n=queue.remove();
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int s = new Q215().findKthLargest(arr, 4);
        System.out.printf("s:" + s);
    }
}
