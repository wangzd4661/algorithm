package lettcode.Q300;

/**
 * 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class Q344 {
    public static void main(String[] args) {

        System.out.printf(reverseString3("abc"));
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverseString2(String s) {
        int n = s.length() - 1;
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

    //左右指针
    public static String reverseString3(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] value = s.toCharArray();
        while (left < right) {
            char temp = value[left];
            value[left] = value[right];
            value[right] = temp;
            left++;
            right--;
        }
        return new String(value);
    }

    public static void reverseString4(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
