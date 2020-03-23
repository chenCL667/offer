/*
给你一根长度为 n 的绳子，
请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m] 。
请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58
 */
public class Offer14 {
    //    利用动态规划来求解
    public int cuttingRope(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i < n + 1; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                max = Math.max(max, product);
            }
            products[i] = max;
        }

        return products[n];
    }


    //    贪心算法 67 841412525
    public int cuttingRope2(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int numOf3 = n / 3;
        if (n - numOf3 * 3 == 1) numOf3--;
        int numOf2 = (n - numOf3 * 3) / 2;
        long res = 1;
        while (numOf3 != 0) {
            res = (res * 3) % 1000000007;
            numOf3--;
        }
        res = (long) ((Math.pow(2, numOf2) * res) % 1000000007);
        return (int) res;
    }

    public static void main(String[] args) {
        Offer14 offer14 = new Offer14();
        for (int i = 0; i < 58; i++) {
            System.out.println(offer14.cuttingRope2(120));
        }
    }
}
