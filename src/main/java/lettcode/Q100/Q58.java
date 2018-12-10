package lettcode.Q100;

/**
 * Created by Administrator on 2018/5/23.
 * 最后一个单词的长度
 */
public class Q58 {
    public static void main(String[] args) {
        int i = lengthOfLastWord("   adsa ");
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int size = 0;
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        while (stringBuilder.length()!=0&&stringBuilder.charAt(0) == ' ') {
            stringBuilder.deleteCharAt(0);
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == ' ') {
                return size;
            }
            size++;
        }
        return size;
    }
}
