package sort;

/**
 * 简单插入排序：把无序列表数字依次插入到有序列表
 * 时间复杂度是O（n*n），空间复杂度是O（1）
 * 稳定排序
 * 很适合近乎有序排序
 */
public class InsertionSort extends Sort {
    @Override
    public void sort(Integer[] arr) {
        if (arr == null || arr.length <= 0) return;
//        for (int i = 1; i < arr.length; i++) {
//            int insertVal = arr[i];
//            int insertIndex = i - 1;
//            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
//                arr[insertIndex + 1] = arr[insertIndex];
//                insertIndex--;
//            }
//            arr[insertIndex + 1] = insertVal;
//        }
//        for (int i = 1; i < arr.length; i++) {
//            // 寻找元素arr[i]合适的插入位置
//            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
//                exch(arr, j - 1, j);
//            }
//        }
        for (int i = 1; i < arr.length; i++) {
            int val=arr[i];
            int index=i-1;
            while (index>=0&&arr[index]>val){
                arr[index+1]=arr[index];
                index--;
            }
            arr[index+1]=val;
        }
    }

    //对[l,r]排序
    public static void sort(Integer[] arr, int l, int r) {
        for (int i = l + 1; i < r + 1; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= l && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }

    /**
     * 二分查找插入排序
     * 二分查找法来减少比较操作的数目
     *
     * @param args
     */
    void sort2(int[] args) {
        if (args == null || args.length <= 0) {
            return;
        }
        for (int i = 1; i < args.length; i++) {
            int temp = args[i];
            int j = i - 1;
            int left = 0;
            int right = i - 1;
            while (left <= right) {  //折半找到插入位置
                int mid = (left + right) / 2;
                if (temp < args[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            while (j >= left) { //i-1到left的数字需要后移一位
                args[j + 1] = args[j];
                j--;
            }
            args[left] = temp; //left即需要插入的位置
        }
    }

    void sort3(Integer[] args) {
        for (int i = 1; i < args.length; i++) {
            // 寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0 && args[j] < args[j - 1]; j--) {
                exch(args, j - 1, j);
            }
        }
    }
    public static void main(String[] args) {
        int n=100000;
        Integer[] a = SortTestHelper.generateRandomArray(n,0,n);
        SortTestHelper.testSort("sort.InsertionSort", a);
        System.out.println(SortTestHelper.isSorted(a));
    }
}
