package lettcode.Q100;

public class Q67 {
    public static void main(String[] args) {
        System.out.print(addBinary("1011", "1"));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i  >= 0) {
                carry = carry + (a.charAt(i) - '0');
            }
            if (j >= 0) {
                carry = carry + (b.charAt(j) - '0');
            }
            sb.append((char) (carry % 2 + '0'));
            carry = carry / 2;
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
