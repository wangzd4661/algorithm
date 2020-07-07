package sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //近乎有序
        Integer[] a = SortTestHelper.generateNearlyOrderedArray(10000000, 1000);
        //随机
        //Integer[] a = SortTestHelper.generateRandomArray(1000000, 1,1000000);
        //System.out.println(Arrays.toString(a));
        SortTestHelper.testSort("sort.ShellSort", a);
        //System.out.println(Arrays.toString(a));
    }
}
