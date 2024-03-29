package lettcode.Q500;

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
    public static int fib2(int N) {
        if(N<=1) return N;
        if(N==1||N==2)return 1;
        int pre=1,cur=1;
        for (int i = 3; i <= N; i++) {
            int sum=pre+cur;
            pre=cur;
            cur=sum;
        }
        return cur;
    }

}
