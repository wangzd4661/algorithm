package lettcode.Q100;

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class Q125 {
    public static void main(String[] args) {
        System.out.printf("" + new Q125().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z')) {
                sb.append(aChar);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
