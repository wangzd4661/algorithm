package array;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int loc = bsSearch5(new int[]{3, 5, 6, 8, 10}, 7);
        System.out.printf("" + loc);
    }

    public static int bsSearch1(int[] arr, int key) {
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

    //查找第一个值等于给定值的元素
    public static int bsSearch2(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (key < arr[mid]) h = mid - 1;
            else if (key > arr[mid]) l = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] != key) return mid;
                else h = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    public static int bsSearch3(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (key < arr[mid]) h = mid - 1;
            else if (key > arr[mid]) l = mid + 1;
            else {
                if (mid == 0 || arr[mid + 1] != key) return mid;
                else l = mid + 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素
    public static int bsSearch4(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] >= key) {
                if (mid == 0 || arr[mid - 1] < key) return mid;
                else h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    public static int bsSearch5(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] <= key) {
                if (mid == arr.length - 1 || arr[mid + 1] > key) return mid;
                else l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}
