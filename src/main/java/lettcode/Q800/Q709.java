package lettcode.Q800;

public class Q709 {
    public static void main(String[] args) {
        String s=toLowerCase("Hello");
        System.out.print(s);
    }

    public static String toLowerCase(String str) {
        if (str == null || str.isEmpty()) return "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 65 && aChar <= 90) {
                chars[i] = (char) (aChar + 32);
            }
        }
        return String.valueOf(chars);
    }
}
