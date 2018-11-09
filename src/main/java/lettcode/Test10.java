package lettcode;


/**
 * Created by Administrator on 2018/5/22.
 * 移除元素
 */
public class Test10 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2};
        int t=removeElement(nums, 3);
        System.out.println(t);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i]==val){
                //int temp=nums[i];
                nums[i]=nums[length-1];
                //nums[length-1]=temp;
                i--;
                length--;
            }
        }
        return length;
    }

}
