package lettcode.interview;

/**
 * 面试题 01.04. 回文排列
 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 */
public class I01_04 {
    public static void main(String[] args) {
        boolean s = new I01_04().canPermutePalindrome("test");
        System.out.printf("" + s);
    }

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        char[] chars = s.toCharArray();
        int[] freq = new int[256];
        for (char aChar : chars) {
            freq[aChar]++;
        }
        int oddCount = 0;
        for (int i : freq) {
            if (i % 2 != 0) oddCount++;
            if (oddCount > 1) return false;
        }
        return true;
    }

}
