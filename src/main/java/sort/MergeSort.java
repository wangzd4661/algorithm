package sort;

import java.util.Arrays;

public class MergeSort extends Sort {
    @Override
    public void sort(Integer[] arr) {
        if (arr == null || arr.length == 0) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(Integer[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void mergeSort2(Integer[] arr, int l, int r) {
        //优化2,小于15用插入排序
        if (r - l < 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort2(arr, l, mid);
        mergeSort2(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1])//（第一个优化）近乎有序，可优化地方，前面大于后面就才用merge
            merge(arr, l, mid, r);
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private void merge(Integer[] arr, int l, int mid, int r) {
        Integer[] temp = Arrays.copyOfRange(arr, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l] < (temp[j - l])) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = temp[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    private void mergeSortBU(Integer[] arr) {
        int n = arr.length;
        // Merge Sort Bottom Up 无优化版本
    /*    for (int sz = 1; sz < n; sz = sz * 2) {
            for (int i = 0; i < n - sz; i = i + sz * 2) {
                //对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }*/
        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for( int i = 0 ; i < n ; i += 16 )
            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );

        for( int sz = 16; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 4, 7, 1, 3};
        new MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
