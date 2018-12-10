package lettcode.Q100;

/**
 * Created by Administrator on 2018/5/15.
 * 反转整数
 */
public class Q7 {
    public static void main(String[] args) {
        int i=-125;
        reverse(i);
    }
    public static int reverse(int x) {
        StringBuilder sb=new StringBuilder(x+"");
        sb=sb.reverse();
        if(x<0){
            sb.deleteCharAt(sb.length()-1);
            sb.insert(0,"-");
        }
        int q=0;
        try {
             q=Integer.valueOf(sb.toString());
        }catch (NumberFormatException ex) {
            q=0;
        }
        return q;
    }
}
