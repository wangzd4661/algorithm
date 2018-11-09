package sort;

/**
 * 选择排序
 * 时间复杂度是O（n*n），空间复杂度是O（1）
 */
public class SelectionSort extends Sort {
    @Override
    public void sort(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[j] < args[i]) {
                    exch(args, i, j);
                }
            }
        }
    }
}
