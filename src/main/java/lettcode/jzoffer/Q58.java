package lettcode.jzoffer;

public class Q58 {
    public static void main(String[] args) {
        String t1 = "abcdefg";
        String t2 = "cdefgab";
        String t3 = "lrloseumgh";
        String t4 = "umghlrlose";
        String r1 = new Q58().reverseLeftWords2(t1, 2);
        if (r1.equals(t2)) {
            System.out.println("success");
        }
        String r2 = new Q58().reverseLeftWords2(t3, 6);
        if (r2.equals(t4)) {
            System.out.println("success");
        }
        System.out.println(2 % 7);
    }

    //空间O（n），时间O(n)
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }

}
