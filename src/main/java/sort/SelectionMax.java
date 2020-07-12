package sort;

public class SelectionMax {
    //寻找arr数组中第k小的元素,k是从0开始索引的, 即最小的元素是第0小元素
    public Integer solve(Integer[] arr, int k) {
        return solve(arr, 0, arr.length - 1, k);
    }

    // 求出arr[l...r]范围里第k小的数
    private Integer solve(Integer[] arr, int l, int r, int k) {
        if (l == r) return arr[l];
        // partition之后, arr[p]的正确位置就在索引p上
        int p = partition(arr, l, r);
        if (k == p)// 如果 k == p, 直接返回arr[p]
            return arr[p];
        else if (k < p)// 如果 k < p, 只需要在arr[l...p-1]中找第k小元素即可
            return solve(arr, l, p - 1, k);
        else// 如果 k > p, 只需要在arr[p+1...r]中找第k小元素即可
            return solve(arr, p + 1, r, k);

    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    // partition 过程, 和快排的partition一样
    // 思考: 双路快排和三路快排的思想能不能用在selection算法中? :)
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++)
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        // 生成一个大小为n, 包含0...n-1这n个元素的随机数组arr
        int N = 10000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 0);
        SortTestHelper.shuffleArray(arr);

        // 验证Selection.solve, 对arr数组求第i小元素, 应该为i
        for (int i = 0; i < N; i++) {
            assert new SelectionMax().solve(arr, i) == i;
            System.out.println("test " + i + " complete.");
        }
        System.out.println("Test Selection.solve completed.");
        System.out.println();
    }
}
