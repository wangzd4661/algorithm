package lettcode.Q200;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class Q242 {
    public static void main(String[] args) {
        System.out.printf(""+isAnagram("car","tar"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return false;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }
}
