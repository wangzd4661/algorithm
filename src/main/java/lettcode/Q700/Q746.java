package lettcode.Q700;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 动态规划最优子结构问题
 */
public class Q746 {
    public static void main(String[] args) {
        int[] n = {10, 15, 20};
        System.out.printf("" + minCostClimbingStairs2(n));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i-1], result[i - 2]+ cost[i-2]);
        }
        return result[cost.length];
    }
    public static int minCostClimbingStairs2(int[] cost) {
        int pre=0,cur=0;
        for (int i = 2; i <=cost.length; i++) {
            int min=Math.min(cur+cost[i-1],pre+cost[i-2]);
            pre=cur;
            cur=min;
        }
        return cur;
    }

}
