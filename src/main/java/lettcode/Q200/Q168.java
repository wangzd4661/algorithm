package lettcode.Q200;

/**
 * 168. Excel表列名称
 */
public class Q168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }

    /**
     * A-Z 65-90
     *
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
