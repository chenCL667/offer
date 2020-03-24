public class Offer16 {
    //    暴力求解法，注意将n取绝对值时需要用long来存储，否则-2147483648取绝对值时会出错
//    public double myPow1(double x, int n) {
////        if (n == 0) return 1;
////        if (n == 1) return x;
////        int isNegative = (n > 0) ? 0 : 1;
////        long times = Math.abs((long) n);
////        double tmp = 1;
////        for (long i = 0; i < times; i++) {
////            tmp = product(tmp, x);
////        }
////        if (isNegative == 1) return 1 / tmp;
////        return tmp;
////    }
////
////    double product(double x, double y) {
////        return x * y;
////    }


    //    二分求解幂
    public double myPow(double x, int n) {
//        处理边界和特殊情况
        if (n == 0) return 1;
        if (n == 1) return x;
//        if (x == 1.0) return 1;

        if (n < 0) {
            x = 1 / x;
            System.out.println(x);
        }
        long times = Math.abs((long)n);
        int rem = 0;
//        如果是奇数次方，则先把指数减掉1，变成偶数次方
        if (times % 2 == 1) {
            times = times - 1;
            rem = 1;
        }

        double tmp = myPow(x, (int) (times / 2));
        return tmp * tmp * myPow(x, rem);
    }

    public static void main(String[] args) {
        Offer16 offer16 = new Offer16();
//        -2147483648
        System.out.println(offer16.myPow(2.000, -2147483648));
//        System.out.println(offer16.myPow1(2.0, -2147483648));
    }
}
