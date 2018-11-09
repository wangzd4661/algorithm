package lettcode;

/**
 * Created by Administrator on 2018/5/17.
 */
public class Test6 {
    public static void main(String[] args) {
        String i = "()(){({})}[]";
        System.out.println(isValid(i)+"");
    }
    public static boolean isValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println("sb:"+sb.toString());
        System.out.println("s:"+s);
        if (s.equals(sb.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
