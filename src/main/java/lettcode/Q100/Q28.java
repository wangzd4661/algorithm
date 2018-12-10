package lettcode.Q100;

/**
 * Created by Administrator on 2018/5/22.
 * 实现strStr()
 */
public class Q28 {
    public static void main(String[] args) {
        String haystack = "hello", needle = "";
        int i=strStr(haystack,needle);
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
