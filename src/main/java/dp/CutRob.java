package dp;

public class CutRob {
    public static int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public static void main(String[] args) {
        for (int i = 1; i <= prices.length; i++)
            System.out.println("长度为" + i + "的最大收益为：" + solution1(i));
    }

    /**
     * 递归
     */
    public static int solution1(int length) {
        if (length == 0) return 0;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            result = Math.max(result, prices[i - 1] + solution1(length - i));
        }
        return result;
    }
}
