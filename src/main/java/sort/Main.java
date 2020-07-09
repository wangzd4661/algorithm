package sort;

public class Main {

    public static void main(String[] args) {
        int n = 1000000;
        //近乎有序
        Integer[] a = SortTestHelper.generateNearlyOrderedArray(n, n / 100);
        //随机
        //Integer[] a = SortTestHelper.generateRandomArray(1000000, 0,1000000);
        //System.out.println(Arrays.toString(a));
        SortTestHelper.testSort("sort.MergeSort", a);
        //System.out.println(Arrays.toString(a));
    }
}
