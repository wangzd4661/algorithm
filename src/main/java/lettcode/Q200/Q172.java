package lettcode.Q200;

/**
 * 172. 阶乘后的零
 */
public class Q172 {
    public static void main(String[] args) {
        for (int i = 1; i <20 ; i++) {
            System.out.println(i+":"+new Q172().trailingZeroes(i));
        }
    }

    public int trailingZeroes(int n) {
        if(n==0) return 0;
        // 0的个数，即因数10的个数。 10=2*5， 等价于质因数2的个数和质因数5的个数的最小值。
        // 因数2的个数远大于因数5的个数，故只计算因数5的个数即可
        int count5 = 0;
        while(n>=5){
            count5 += n/5;
            n /= 5;
        }
        return count5;
    }
}
