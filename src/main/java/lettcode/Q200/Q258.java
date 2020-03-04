package lettcode.Q200;

/**
 * 258. 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 */
public class Q258 {
    public static void main(String[] args) {
        System.out.print("" + addDigits2(38));
    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int result = 0;
        String str = num + "";
        while (str.length() != 1) {
            result = 0;
            for (int i = 0; i < str.length(); i++) {
                result = result + Integer.valueOf(str.charAt(i) - '0');
            }
            str = result + "";
        }
        return result;
    }
    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
