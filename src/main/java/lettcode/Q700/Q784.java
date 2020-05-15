package lettcode.Q700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * https://leetcode-cn.com/problems/letter-case-permutation/
 */
public class Q784 {
    public static void main(String[] args) {
        List<String> r = new Q784().letterCasePermutation("a1b2");
        System.out.printf("" + Arrays.toString(r.toArray()));
    }

    private List<String> res;
    public List<String> letterCasePermutation(String S) {
        res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        char[] chars = S.toCharArray();
        findLetters(chars, 0, "");
        return res;
    }
    private void findLetters(char[] chars, int index, String letter) {
        if (letter.length() == chars.length) {
            res.add(letter);
            return;
        }
        char c = chars[index];
        if (Character.isLetter(c)) {
            findLetters(chars, index + 1, letter + Character.toLowerCase(c));
            findLetters(chars, index + 1, letter + Character.toUpperCase(c));
        } else {
            findLetters(chars, index + 1, letter + c);
        }
    }

}
