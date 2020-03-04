package lettcode.Q001;

/**
 * Created by Administrator on 2018/5/24.
 * x 的平方根
 */
public class Q69 {
    public static void main(String[] args) {
        int n = 101;
        //System.out.println(mySqrt(n));
        System.out.println(mySqrt2(n));
    }

    public static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     *
     * @param
     * @return
     */
    public static double mySqrt2(int num) {
        double x=Math.sqrt(num);
        double y=num/2.0;
        int count=1;
        while (Math.abs(y-x)>0.00000001) {
            System.out.println(count+"hh"+y);
            count += 1;
            y=((y*1.0)+(1.0*num)/y)/2.0000;
        }
        return y;
    }
}
