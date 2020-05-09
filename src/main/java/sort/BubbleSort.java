package sort;

/**
 * 冒泡排序
 * 时间复杂度是O（n*n），空间复杂度是O（1）
 * 稳定排序：在排序过程中，元素两两交换时，相同元素的前后顺序并没有改变
 * 可优化地方：设置flag记录当前这趟循环发生交换没，没交换直接结束
 */
public class BubbleSort extends Sort {
    @Override
    void sort(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = 0; j < args.length - 1 - i; j++) {
                if (args[j] > args[j + 1]) {
                    exch(args, j, j + 1);
                }
            }
        }
    }
}
