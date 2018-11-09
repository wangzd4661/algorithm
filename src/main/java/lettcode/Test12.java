package lettcode;

/**
 * Created by Administrator on 2018/5/22.
 * 搜索插入位置
 */
public class Test12 {
    public static void main(String[] args) {
        int[] nums = {1,1, 3,4,5, 6};
        int t = searchInsert2(nums, 2);
        System.out.println(t);
    }

    public static int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while (low<=high){
            int mid = (low+high)>>>1;
            int midVal=nums[mid];
            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }
    public static int searchInsert2(int[] nums, int target) {
        if(nums.length == 0) return 0;

        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] >= target) return i;
        }

        return nums.length;

    }
}
