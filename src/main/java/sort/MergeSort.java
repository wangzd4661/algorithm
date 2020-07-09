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
        merge(arr,l,mid,r);
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
            } else if (temp[i - l]<(temp[j - l])) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = temp[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr=new Integer[]{5, 4, 7, 1, 3};
        new MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
