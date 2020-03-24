public class Offer17 {
    public int[] printNumbers(int n) {
        int length = (int) (Math.pow(10, n) - 1);
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    public void printNumbers2(int n) {
        int length = (int) (Math.pow(10, n));
        for (int i = 1; i < length; i++) {
            System.out.println(int2char(i, n));
        }
    }

    private char[] int2char(int num, int n) {
        char[] res = new char[n + 1];
        char[] reverse = new char[n + 1];
        int index = 0;
        while (num != 0) {
            res[index++] = (char) ((num%10) + '0');
            num = num / 10;
        }

        for (int i = 0; i < index; i++) {
            reverse[i] = res[index - i - 1];
        }
        reverse[index] = '\0';
        return reverse;
    }

    public static void main(String[] args) {
        int n = 3;
        Offer17 offer17 = new Offer17();
//        for (int e : offer17.prin/

        offer17.printNumbers2(8);
    }
}
