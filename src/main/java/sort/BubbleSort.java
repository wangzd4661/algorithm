package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度是O（n*n），空间复杂度是O（1）
 * 稳定排序：在排序过程中，元素两两交换时，相同元素的前后顺序并没有改变
 * 可优化地方：设置flag记录当前这趟循环发生交换没，没交换直接结束
 */
public class BubbleSort extends Sort {
    @Override
    public void sort(Integer[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 提前退出
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    exch(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    void sort2(Integer[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    exch(arr, j, j+1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        int n=100000;
        Integer[] a = SortTestHelper.generateRandomArray(n,0,n);
        SortTestHelper.testSort("sort.BubbleSort", a);
        System.out.println(SortTestHelper.isSorted(a));
    }
}
