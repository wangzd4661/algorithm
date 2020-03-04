package lettcode.Q500;

/**
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class Q557 {
    public static void main(String[] args) {
        System.out.printf(reverseWords("da ge hao"));
    }

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) return "";
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int lenth = str.length;
        for (int i = 0; i < lenth; i++) {
            sb.append(new StringBuilder(str[i]).reverse());
            if (i < str.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
