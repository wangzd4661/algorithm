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
            n = queue.remove();
        }
        return n;
    }

    //使用快速排序思想
    public int findKthLargest2(int[] nums, int k) {
        return solve(nums, 0, nums.length - 1, nums.length-k);
    }

    // 求出arr[l...r]范围里第k小的数
    private int solve(int[] arr, int l, int r, int k) {
        if (l == r) return arr[l];
        int p = partition(arr, l, r);
        if (k == p) return arr[p];
        else if (k < p) return solve(arr, l, p - 1, k);
        else return solve(arr, p + 1, r, k);
    }

    private int partition(int[] arr, int l, int r) {
        //随机标定点
        exch(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        int x = arr[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (arr[j] <= x) {
                exch(arr, ++i, j);
            }
        }
        exch(arr, i + 1, r);
        return i + 1;
    }

    private void exch(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1,5,6,4};
        int s = new Q215().findKthLargest2(arr, 2);
        System.out.printf("s:" + s);
    }
}
