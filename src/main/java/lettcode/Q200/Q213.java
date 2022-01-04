package lettcode.Q200;


public class Q213 {
    public static void main(String[] args) {
        int[] n = {1,3,1,3,100};
        System.out.printf("" + rob(n));
    }


    public static int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
    }
    public static int robRange(int[] nums,int start,int end) {
        int pre=nums[start];
        int cur=Math.max(nums[start+1],nums[start]);
        for (int i = start+2; i <=end; i++) {
            int max=Math.max(pre+nums[i],cur);
            pre=cur;
            cur=max;
        }
        return cur;
    }
}
