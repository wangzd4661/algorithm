package lettcode.jzoffer;

public class Q53 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2};
        int search = new Q53().search2(arr, 2);
        System.out.println(search);
    }

    //思路1：数组已排序，二分查找比较快。找到一个arr[index]==target,然后在遍历index前后，直到arr[i]不等于target.
    public int search(int[] nums, int target) {
        int index = bsSearch(nums, target);
        if (index != -1) {
            int i = index-1, j = index+1;
            int count = 0;
            int length = nums.length - 1;
            while (i >= 0 && nums[i] == target) {
                count++;
                i--;
            }
            while (j <= length && nums[j] == target) {
                count++;
                j++;
            }
            return count+1;
        }
        return 0;
    }

    public int bsSearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else return mid;
        }
        return -1;
    }
    //思路2：找到第一个target位置，找到最后一个target位置，相减
    public int search2(int[] nums, int target) {
        int indexFirst = bsSearchFirst(nums, target);
        int indexLast = bsSearchLast(nums, target);
        System.out.println(indexFirst+","+indexLast);
        if(indexFirst==-1) return 0;
        else return indexLast-indexFirst+1;
    }
    public int bsSearchFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else {
                if(mid==0||nums[mid-1]!=target)return mid;
                else r=mid-1;
            }
        }
        return -1;
    }
    public int bsSearchLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else {
                if(mid==nums.length-1||nums[mid+1]!=target)return mid;
                else l=mid+1;
            }
        }
        return -1;
    }
}
