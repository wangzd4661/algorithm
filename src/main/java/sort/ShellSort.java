package sort;

import java.util.Arrays;

public class ShellSort extends Sort {
    @Override
    void sort(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        int gap, i, j;
        int temp, len = args.length;
        for (gap = len >> 1; gap > 0; gap >>= 1)
            for (i = gap; i < len; i++) {
                temp = args[i];
                for (j = i - gap; j >= 0 && args[j] > temp; j -= gap) {
                    args[j + gap] = args[j];
                }
                args[j + gap] = temp;
                System.out.println("gap:" + gap + Arrays.toString(args));
            }

    }
}
