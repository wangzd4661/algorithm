package lettcode.Q900;

import java.util.TreeSet;

/**
 * 804. 唯一摩尔斯密码词
 */
public class Q804 {
    public static void main(String[] args) {

    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                sb.append(code[s.charAt(j) - 'a']);
            }
            treeSet.add(sb.toString());
        }
        return treeSet.size();
    }
}
