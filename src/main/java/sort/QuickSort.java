package sort;

public class QuickSort extends Sort {
    @Override
    public void sort(Integer[] args) {
        quickSort3(args, 0, args.length - 1);
    }

    private void quickSort(Integer[] arr, int l, int r) {
        /* if (l >= r) return;*/
        // 优化1：对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private int partition(Integer[] arr, int l, int r) {
        //优化2：随机选择标定点,防止有序列表时间复杂度退化到(O^2)
        exch(arr, l, (int) (Math.random() * (r - l + 1)) + l);
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
    //双路快排
    private void quickSort2(Integer[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partition2(arr, l, r);
        quickSort2(arr, l, p - 1);
        quickSort2(arr, p + 1, r);
    }
    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private int partition2(Integer[] arr, int l, int r) {
        exch(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Integer v = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l+1 && arr[j] > v) j--;
            if (i > j) break;
            exch(arr,i,j);
            i++;
            j--;
        }
        exch(arr,l,j);
        return j;
    }
    //三路快排
    private void quickSort3(Integer[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        //partition过程
        exch(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Integer v = arr[l];
        int lt=l;   //arr[l+1,lt]<v
        int gt=r+1; //arr[gt,r]>v
        int i=l+1;  //arr[lt+1,i]==v
        while (i<gt){
            if(arr[i]<v){//
                exch(arr,i,lt+1);
                lt++;
                i++;
            }else if(arr[i]>v){
                exch(arr,i,gt-1);
                gt--;
            }else {// arr[i]==v
                i++;
            }
        }
        exch(arr,l,lt);

        quickSort3(arr, l, lt - 1);
        quickSort3(arr, gt, r);
    }


    public static void main(String[] args) {
        int n = 1000000;
        //近乎有
        Integer[] a = SortTestHelper.generateNearlyOrderedArray(n, 1000);
        //随机
        //Integer[] a = SortTestHelper.generateRandomArray(n, 0, 10);
        //new QuickSort().sort(a);
        SortTestHelper.testSort("sort.QuickSort", a);
        System.out.println(SortTestHelper.isSorted(a));
    }
}
