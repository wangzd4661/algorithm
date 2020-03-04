package lettcode.Q100;

/**
 * 169. 求众数
 */
public class Q169 {
    public static void main(String[] args) {
        int[] n = {3,2,3};
        System.out.printf(""+majorityElement(n));
    }

    public  static int majorityElement(int[] nums) {
        int n = nums[0];
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            if (r == 0) {
                n = nums[i];
            }
            if (n == nums[i]) {
                r = r + 1;
            } else {
                r = r - 1;
            }
        }
        return n;
    }
}
