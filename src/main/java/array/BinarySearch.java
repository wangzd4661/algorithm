package array;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int loc=rank(new int[]{1,5,7,8,9,10},5);
        System.out.printf(""+loc);
    }

    public static int rank(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (key < arr[mid]) h = mid - 1;
            else if (key > arr[mid]) l = mid + 1;
            else return mid;
        }
        return -1;
    }
}
