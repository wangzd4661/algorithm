package sort;

public class Main {
    public static final String QuickSort = "sort.QuickSort";
    public static final String MergeSort = "sort.MergeSort";

    public static void main(String[] args) {
        int n = 1000000;
        //近乎有
        // Integer[] a = SortTestHelper.generateNearlyOrderedArray(n, n / 100);
        //随机
        Integer[] a = SortTestHelper.generateRandomArray(n, 0, n);
        //System.out.println(Arrays.toString(a));
        SortTestHelper.testSort(QuickSort, a);
        //System.out.println(Arrays.toString(a));
    }
}
