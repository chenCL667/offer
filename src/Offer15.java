public class Offer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
//        解法1:
//        模拟一个数转成对应二进制的过程，并计算这个过程中出现的1的个数
//        int cnt = 0;
//        if (n >= 0) {
//            while(n != 0){
//                cnt = cnt + (n % 2);
//                n = n / 2;
//            }
//        }
//        else {
//            n = Math.abs(n) - 1;
//            while(n != 0){
//                cnt = cnt + (n % 2);
//                n = n / 2;
//            }
//            cnt = 32 - cnt;
//        }
//        return cnt;

//        解法2：
//        每次将n的最后一位和数字1进行与运算，结果为1说明原来最后一位为1，否则为0
//        每次判断完最后一位后，将n右移一位，注意这里是有符号数的右移操作
//        int cnt = 0;
//        while (n != 0) {
//            cnt += (n & 1);
//            n =shang'chu n >>> 1;
//        }
//        return cnt;

//        解法3：
//        上述解法2是将n不断向右移并和1进行与运算
//        解法3这里不改变n,而是将数字1每次向左移动一位
//        例如最初是 n & 1, 第二轮是 n & (1<<1), 第三轮是 n & (1<<2)
//        每个数字需要进行32次移位操作
//        int cnt = 0;
//        int flag = 1;
//        while (flag != 0) {
//            if ((n & flag) != 0)
//                cnt++;
//            flag = flag << 1;
//        }
//        return cnt;


//        解法4：
//        n &（n-1）会将n最右边的1变成0；
//        不断进行此操作可以将n的二进制中1的个数统计出来
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 10;
        Offer15 offer15 = new Offer15();
        System.out.println(offer15.hammingWeight(n));

        n = 0;
        System.out.println(offer15.hammingWeight(n));

        n = -10;
        System.out.println(offer15.hammingWeight(n));


    }

}
