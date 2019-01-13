package lettcode.Q600;

/**
 * 509. 斐波那契数
 */
public class Q509 {
    public static void main(String[] args) {
        System.out.printf(""+fib(2));
    }
    public static int fib(int N) {
        if(N<=0) return N;
        int[] m=new int[N+1];
        m[0]=0;
        m[1]=1;
        for(int i=2;i<=N;i++){
            m[i]=m[i-1]+m[i-2];
        }
        return m[N];
    }

}
