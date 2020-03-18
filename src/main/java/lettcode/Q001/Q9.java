package lettcode.Q001;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/16.
 *回文数
 *
 */
public class Q9 {
    public static void main(String[] args) {
        int i = 1234321;
        System.out.println(isPalindrome3(i)+"");
    }

    /**
     * 使用 String
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String s = x + "";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (s.equals(sb.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome2(int x) {
        int first = x;
        int s;
        ArrayList<Integer> list = new ArrayList();
        while (x > 0) {
            s = x % 10;
            list.add(0, s);
            x = x / 10;
        }
        int sum = 0;
        for (int j = list.size() - 1; j >= 0; j--) {
            sum = sum + ((int) Math.pow(10, j) * list.get(j));
        }
        if (sum == first) {
            return true;
        } else {
            return false;
        }
    }
    // 特殊情况：
    // 如上所述，当 x < 0 时，x 不是回文数。
    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
    // 则其第一位数字也应该是 0
    // 只有 0 满足这一属性

    // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
    // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
    // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }


}
