package sort;

public class QuickSort extends Sort {
    @Override
    public void sort(Integer[] args) {
        quickSort(args, 0, args.length - 1);
    }

    private void quickSort(Integer[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private int partition(Integer[] arr, int l, int r) {
        Integer v = arr[l];
        int j = l;// arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                exch(arr, j, i);
            }
        }
        exch(arr, j, l);
        return j;
    }

    public static void main(String[] args) {
        int n = 1000000;
        //近乎有
        //Integer[] a = SortTestHelper.generateNearlyOrderedArray(n, n / 100);
        //随机
        Integer[] a = SortTestHelper.generateRandomArray(n, 0,n);
        //new QuickSort().sort(a);
        SortTestHelper.testSort("sort.QuickSort", a);
        System.out.println(SortTestHelper.isSorted(a));
    }
}
