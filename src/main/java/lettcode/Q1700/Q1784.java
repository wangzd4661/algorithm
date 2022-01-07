package lettcode.Q1700;

public class Q1784 {
    public static void main(String[] args) {
        boolean b = new Q1784().checkOnesSegment("1001");
        System.out.println(b);
    }
    //思路1：满足题意true的结果只能是：1，10，100，110，111。
    //从发现0开始的位置往后检查是否还包含1
    public boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        boolean beginCheck = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') beginCheck = true;
            if (beginCheck && chars[i] == '1') return false;
        }
        return true;
    }
    //思路2：只要包含"01"则不满足
    public boolean checkOnesSegment2(String s) {
        return !s.contains("01");
    }
}
