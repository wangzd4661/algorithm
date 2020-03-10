package lettcode.interview;

/**
 * 面试题10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * 同Q509
 */
public class I10_1 {
    public static  int fib(int n) {
        if (n <= 0) return n;
        int[] m=new int[n+1];
        m[0]=0;
        m[1]=1;
        for(int i=2;i<=n;i++){
            m[i]=(m[i-1]+m[i-2])%1000000007;
        }
        return m[n];
    }
    public static void main(String[] args) {
        System.out.printf(""+fib(48));
    }
}
