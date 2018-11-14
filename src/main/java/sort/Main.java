package sort;

import java.util.Arrays;

public class Main {
    public static int[] a = {7,4,2};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        Sort sort = new ShellSort();
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
