package lettcode.Q800;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 动态规划最优子结构问题
 */
public class Q746 {
    public static void main(String[] args) {
        int[] n = {10, 15, 20};
        System.out.printf("" + minCostClimbingStairs(n));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];
        for (int i = 2; i < cost.length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i], result[i - 1]);
        }
        return result[cost.length - 1];
    }

}
