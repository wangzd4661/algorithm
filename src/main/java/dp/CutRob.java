package dp;

public class CutRob {
    public static int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public static void main(String[] args) {
        for (int i = 1; i <= prices.length; i++) {
            System.out.println("1长度为" + i + "的最大收益为：" + solution1(i));
            System.out.println("2长度为" + i + "的最大收益为：" + solution2(i));
        }
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

    public static int solution2(int p) {
        int[] r = new int[p + 1];
        for (int i = 1; i <= p; i++) {
            int q = -1;
            for (int j = 1; j <= i; j++) {
                int tmp = prices[j - 1] + r[i - j];
                q = q > tmp ? q : tmp;
            }
            r[i] = q;
        }
        return r[p];
    }

}
