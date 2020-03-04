package lettcode.Q500;

/**
 * 520. 检测大写字母
 * https://leetcode-cn.com/problems/detect-capital/
 */
public class Q520 {
    public static void main(String[] args) {
        System.out.printf(""+detectCapitalUse("GooG"));
    }

    public static boolean detectCapitalUse(String word) {
        return word.toUpperCase().equals(word) ||
                word.toLowerCase().equals(word) ||
                (word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()).equals(word);
    }
}
