package lettcode.jzoffer;

public class Q5 {
    public static void main(String[] args) {
        String t1 = "We are happy.";
        String t2 = "We%20are%20happy.";
        String s = new Q5().replaceSpace2(t1);
        if (t2.equals(s)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }

    //遍历每个字符？
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

    public String replaceSpace2(String s) {
        if (s == null || s.length() == 0) return "";
        return s.replace(" ", "%20");
    }
    //原地替换？

}
