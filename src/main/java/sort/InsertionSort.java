package sort;

import java.util.Arrays;

/**
 * 简单插入排序：把无序列表数字依次插入到有序列表
 * 时间复杂度是O（n*n），空间复杂度是O（1）
 * 稳定排序
 * 很适合近乎有序排序
 */
public class InsertionSort extends Sort {
    @Override
    public void sort(Integer[] arr) {
        if (arr == null || arr.length <= 0) return;
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }

    /**
     * 二分查找插入排序
     * 二分查找法来减少比较操作的数目
     *
     * @param args
     */
    void sort2(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        for (int i = 1; i < args.length; i++) {
            int temp = args[i];
            int j = i - 1;
            int left = 0;
            int right = i - 1;
            while (left <= right) {  //折半找到插入位置
                int mid = (left + right) / 2;
                if (temp < args[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            while (j >= left) { //i-1到left的数字需要后移一位
                args[j + 1] = args[j];
                j--;
            }
            args[left] = temp; //left即需要插入的位置
        }
    }

    void sort3(Integer[] args) {
        for (int i = 1; i < args.length; i++) {
            // 寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0 && args[j] < args[j - 1]; j--) {
                exch(args, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {101,34,119,1};
        new InsertionSort().sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
