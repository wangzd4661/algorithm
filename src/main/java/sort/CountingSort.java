package sort;

public class CountingSort extends Sort {
    @Override
    void sort(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        //1.找数组中最大值和最小值
        int max = args[0], min = args[0];
        for (int arg : args) {
            if (arg < min) {
                min = arg;
            }
            if (arg > max) {
                max = arg;
            }
        }
        //2.C为计，b为填充的数组
        int k = max - min + 1;
        int[] c = new int[k];
        int[] b = new int[args.length];
        //3.
        for (int arg : args) {
            c[arg - min]++;
        }
        //4.
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        //5.
        for (int arg : args) {
            b[--c[arg - min]] = arg;
        }
        //6.
        for (int i = 0; i < args.length; i++) {
            args[i] = b[i];
        }


    }
}
