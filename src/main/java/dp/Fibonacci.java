package dp;

/**
 * 斐波拉契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci dp = new Fibonacci();
        int n = 6;//n>0
        int[] Memo = new int[n + 1];
        for (int i = 0; i <= n; i++)
            Memo[i] = -1;
        int i = dp.fib3(n);
        System.out.printf("" + i);
    }

    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 自顶向下的备忘录法
     * 也使用了递归。但是减少了递归的次数
     *
     * @param n
     * @param m
     * @return
     */
    public int fib2(int n, int[] m) {
        System.out.print(n + ",");
        if (m[n] != -1)
            return m[n];
        if (n <= 2)
            m[n] = 1;
        else m[n] = fib2(n - 1, m) + fib2(n - 2, m);
        return m[n];
    }

    /**
     * 自底向上
     * @param n
     * @return
     */
    public int fib3(int n) {
        if(n<=0)
            return n;
        int []Memo=new int[n+1];
        Memo[0]=0;
        Memo[1]=1;
        for(int i=2;i<=n;i++)
        {
            Memo[i]=Memo[i-1]+Memo[i-2];
        }
        return Memo[n];
    }
    public  int fib4(int n)
    {
        if(n<=1)
            return n;

        int Memo_i_2=0;
        int Memo_i_1=1;
        int Memo_i=1;
        for(int i=2;i<=n;i++)
        {
            Memo_i=Memo_i_2+Memo_i_1;
            Memo_i_2=Memo_i_1;
            Memo_i_1=Memo_i;
        }
        return Memo_i;
    }

}

