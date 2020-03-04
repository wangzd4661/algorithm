package lettcode.Q100;

/**
 * 171. Excel表列序号
 */
public class Q171 {
    public static void main(String[] args) {
        System.out.printf("" + titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = 0, carry = 1;
        char[] cs = s.toCharArray();
        int length = cs.length - 1;
        for (int i = length; i >= 0; i--) {
            int c = cs[i] - 'A' + 1;
            n = n + c * carry;
            carry = 26 * carry;
        }
        return n;
    }
}
