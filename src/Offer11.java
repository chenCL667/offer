public class Offer11 {
    public int minArray(int[] numbers) {
//        暴力遍历法
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] < min) {
//                min = numbers[i];
//            }
//        }
//        return min;


        int begin = 0, end = numbers.length - 1;
        int mid = 0;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (numbers[mid] > numbers[end]) begin = mid + 1;
            else if (numbers[mid] < numbers[end]) end = mid;
            end--;
        }
        return numbers[begin];
    }

    public static void main(String[] args) {
        int[] numbers = {3, 3, 1, 3};
        Offer11 offer11 = new Offer11();
        System.out.println(offer11.minArray(numbers));
    }
}
