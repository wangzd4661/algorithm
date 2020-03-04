package lettcode.Q300;

/**
 * 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class Q344 {
    public static void main(String[] args) {

        System.out.printf(reverseString2("abc"));
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverseString2(String s) {
        int n = s.length()-1;
        char[] value = s.toCharArray();
        for (int i = (n - 1) >> 1; i >= 0; i--) {
            int k = n - i;
            char cj = value[i];
            char ck = value[k];
            value[i] = ck;
            value[k] = cj;
        }
        return new String(value);
    }
}
