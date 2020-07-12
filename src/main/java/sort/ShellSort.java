package sort;

public class ShellSort extends Sort {
    @Override
    //交换法：1百万：1245ms
    public void sort(Integer[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {

                // 将 arr[i]插入到 arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    exch(arr, j, j - h);
                }
            }
            h /= 3;
        }

    }

    //移位法：1百万：779ms
    public void sort2(Integer[] arr) {
        if (arr == null || arr.length == 0) return;
        int gap = 1;
        int n = arr.length;
        while (gap < n / 3) gap = 3 * gap + 1;
        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = temp;
                }
            }
            gap = gap / 3;
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {10, 9, 8, 7, 5, 6, 4, 3, 2, 1};
        new ShellSort().sort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
