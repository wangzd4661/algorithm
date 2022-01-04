package lettcode.Q700;

public class Q740 {
    public static void main(String[] args) {
        int res=new Q740().deleteAndEarn(new int[]{3,4,2});
        System.out.println(res);
    }
    //把nums中每个数字的值作为下标组成新数组，值为nums中该数字所有相同数字之和。转换为打家劫舍问题。不能选择相邻元素。
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for (int num : nums) {
            max=Math.max(max,num);
        }
        int[] sums=new int[max+1];
        for (int num : nums) {
            sums[num]+=num;
        }
        return rob(sums);

    }
    public int rob(int[] sums) {
        int pre=sums[0];
        int cur=sums[1];
        for (int i = 2; i < sums.length; i++) {
            int max=Math.max(pre+sums[i],cur);
            pre=cur;
            cur=max;
        }
        return cur;
    }
}
