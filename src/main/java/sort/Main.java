package sort;

import java.util.Arrays;

public class Main {
    public static int[] a = {1, 7, 8, 2, 9, 5, 4,1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        Sort sort = new CountingSort();
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
