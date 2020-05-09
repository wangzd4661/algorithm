package sort;

/**
 * 选择排序
 * 时间复杂度是O（n*n），空间复杂度是O（1）
 * 不稳定排序：eg：5 8 5 2 7
 * 换的次数少于冒泡，n值较小时，选择排序比冒泡排序快。
 */
public class SelectionSort extends Sort {
    @Override
    public void sort(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        for (int i = 0; i < args.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < args.length; j++) {
                if (args[j] < args[minPos]) {
                    minPos = j;
                }
            }
            if (i != minPos) {
                exch(args, i, minPos);
            }
        }
    }
    public static void main(String[] args) {

        int[] arr = {6,5,5,3,2,1};
        new SelectionSort().sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public void sort2(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        for (int i = 0; i < args.length; i++) {
            //[i,n)区间寻找最小值索引
            int min = i;
            for (int j = i+1; j < args.length; j++) {
                if (args[j] < args[min]) {
                    min = j;
                }
            }
            exch(args, i, min);
        }
    }
}
