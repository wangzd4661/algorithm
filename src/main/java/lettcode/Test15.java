package lettcode;

/**
 * Created by Administrator on 2018/5/24.
 * 二进制求和
 */
public class Test15 {
    public static void main(String[] args) {
        String s = addBinary("11", "1");
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
        int carry = 0;
        int length = a.length() > b.length() ? a.length() : b.length();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1') {

            } else if (a.charAt(i) == '0' && b.charAt(i) == '1') {

            } else if (a.charAt(i) == '1' && b.charAt(i) == '0') {

            } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {

            }
        }
        return "";
    }
}
