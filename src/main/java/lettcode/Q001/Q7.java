package lettcode.Q001;

/**
 * Created by Administrator on 2018/5/15.
 * 反转整数
 */
public class Q7 {
    public static void main(String[] args) {
        System.out.println((Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse2(Integer.MAX_VALUE));
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder(x + "");
        sb = sb.reverse();//O(x.len)
        if (x < 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, "-");
        }
        int q = 0;
        try {
            q = Integer.valueOf(sb.toString());//O(x.len)
        } catch (NumberFormatException ex) {
            q = 0;
        }
        return q;
    }
    // Time : O(logx) Space : O(1)
    public static int reverse2(int x) {
        if (x == 0) return 0;
        int sign = x > 0 ? 1 : -1;
        long num = Math.abs(x);
        long reverseNum = 0;
        while (num > 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num = num / 10;
        }
        reverseNum = reverseNum * sign;
        if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE) return 0;
        return (int)reverseNum;
    }
}
