package lettcode.Q001;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 动态规划的重叠子问题
 */
public class Q70 {
    public static void main(String[] args) {
        System.out.printf("" + climbStairs(4));
    }

    /**
     * f(5)=f(3)+f(4)
     * f(5)两种情况，选1步转为求f(3),选2步转为求f(4)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] result = new int[n + 2];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
    public static int climbStairs2(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int pre=1,cur=2;
        for (int i = 3; i <=n; i++) {
            int sum=pre+cur;
            pre=cur;
            cur=sum;
        }
        return cur;
    }
}
