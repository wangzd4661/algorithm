package sort;

import heap.MaxHeap;

public class HeapSort extends Sort {
    @Override
    public void sort(Integer[] arr) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr,n,i);
        }
        for (int i = n-1; i >0 ; i--) {
            exch(arr,0,i);
            shiftDown(arr,i,0);
        }
    }

    private void shiftDown(Integer[] arr, int n, int k) {
        Integer e = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j = j + 1;
            }
            if (e >= arr[j]) break;
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    public void sort2(Integer[] arr) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        //近乎有
        Integer[] a = SortTestHelper.generateNearlyOrderedArray(n, n / 100);
        //随机
        //Integer[] a = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("sort.HeapSort", a);
        System.out.println(SortTestHelper.isSorted(a));
    }
}
