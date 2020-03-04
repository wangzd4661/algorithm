package lettcode.Q001;


/**
 * Created by Administrator on 2018/5/22.
 * 移除元素
 */
public class Q27 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2};
        int t = removeElement2(nums, 3);
        System.out.println(t);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                nums[i] = nums[length - 1];
                i--;
                length--;
            }
        }
        return length;
    }

    public static int removeElement2(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != k) {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                }
                k++;
            }
        }
        return k;
    }
}
