public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorderRecur(0, postorder.length - 1, postorder);
    }

    private boolean verifyPostorderRecur(int begin, int end, int[] postorder) {
        if (begin > end) return true;
        if (begin == end) return true;
        int index = begin, mid = 0;
        while (index <= end && postorder[index] < postorder[end]) index++;
        mid = index;
        while (index <= end && postorder[index] > postorder[end]) index++;
        return index == end && verifyPostorderRecur(begin, mid - 1, postorder) && verifyPostorderRecur(mid, end - 1, postorder);
    }

    public static void main(String[] args) {
        Offer33 offer33 = new Offer33();
        int[] postorder = {1,3,2,6,4,5};
        System.out.println(offer33.verifyPostorder(postorder));
    }
}
