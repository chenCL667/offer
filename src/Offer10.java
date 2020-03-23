/**
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Offer10 {
    public int fib(int n) {
//        递归实现
//        if (n == 0 || n == 1) return n;
//        else return (fib(n-1)%1000000007 + fib(n-2)%1000000007)%1000000007;

//        循环实现
        int front = 0;
        int rear = 1;
        if (n == 0) return front;
        if (n == 1) return rear;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (front + rear) % 1000000007;
            front = rear;
            rear = res;
        }
        return res;
    }


    public int numWays(int n) {
        if (n == 0) return 1;
        if (n < 3) return n;

        int prev1 = 1;
        int prev2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = (prev1 + prev2) % 1000000007;
            prev1 = prev2;
            prev2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer10 offer10 = new Offer10();
        System.out.println(offer10.fib(0));
        System.out.println(offer10.fib(1));
        System.out.println(offer10.fib(100));
        System.out.println(offer10.numWays(100));
    }
}
