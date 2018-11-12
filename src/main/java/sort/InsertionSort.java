package sort;
/**
 * 简单插入排序
 * 时间复杂度是O（n*n），空间复杂度是O（1）
 * 稳定排序
 */
public class InsertionSort extends Sort {
    @Override
    void sort(int[] args) {
        for (int i = 1; i < args.length; i++) {
            int temp = args[i];
            int j = i - 1;
            while (j >= 0 && args[j] > temp) {
                args[j + 1] = args[j];
                j--;
            }
            args[j + 1] = temp;
        }
    }
}
