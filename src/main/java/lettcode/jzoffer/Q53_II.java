package lettcode.jzoffer;

public class Q53_II {
    public static void main(String[] args) {
        int[] r = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        int i = new Q53_II().missingNumber(r);
        if (i == 8) {
            System.out.println("success");
        }
    }

    //思路：二分法
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
