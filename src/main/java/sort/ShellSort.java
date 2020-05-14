package sort;

public class ShellSort extends Sort {
    @Override
    void sort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            System.out.println("Q:"+h);
            // h-sort the array
            for (int i = h; i < n; i++) {

                // 将 arr[i]插入到 arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                for (int j = i; j >=h&&arr[j]<arr[j-h] ; j-=h) {
                    exch(arr,j,j-h);
                }
            }
            h /= 3;
        }

    }
    public static void main(String[] args) {

        int[] arr = {10,9,8,7,5,6,4,3,2,1};
        new ShellSort().sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
