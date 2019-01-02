package lettcode.Q100;

/**
 * Created by Administrator on 2018/5/14.
 * 删除排序数组中的重复项
 */
public class Q26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        int l = removeDuplicates2(nums);
        System.out.println("" + l);
        print(nums);
    }

    /**
     * 未排序好的
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            for (int j = i + 1; j < nums.length - len; j++) {
                if (one == nums[j]) {
                    for (int k = j; k < nums.length - 1; k++) {
                        nums[k] = nums[k + 1];
                    }
                    j--;
                    print(nums);
                    len++;
                }
            }
        }
        return (nums.length - len);
    }

    /**
     * 排序好了的
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 0;
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[num]) {
                len++;
                num = i;
                nums[len] = nums[i];
            }
        }
        return (len + 1);
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println("");
    }
}

