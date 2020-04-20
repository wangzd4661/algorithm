package lettcode.Q001;


import java.util.Arrays;

/**
 *75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Q75 {
    public static void main(String[] args) {
        int[] arr={2,0,2,1,1,0};
        sortColors(arr);
    }
    //思想：两个标定点，[0,zero],[zero+1,two-1],[two,len-1]三段
    public static void sortColors(int[] nums) {
        int zero=-1;
        int two=nums.length;
        for (int i = 0; i < two;) {
            if(nums[i]==1){
                i++;
            }else if (nums[i]==2){
                two--;
                int temp=nums[i];
                nums[i]=nums[two];
                nums[two]=temp;
            }else {//num[i]==0
                zero++;
                int temp=nums[i];
                nums[i]=nums[zero];
                nums[zero]=temp;
                i++;
            }
        }
        System.out.println("Q75.sortColors"+ Arrays.toString(nums));
    }
}
