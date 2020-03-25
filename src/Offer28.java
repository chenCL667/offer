public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B != null) return false;
        if (A != null && B == null) return false;
        if (A == null && B == null) return true;
        if (A.val != B.val) return false;
        return isSameTree(A.left, B.right) && isSameTree(A.right, B.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Offer28 offer28 = new Offer28();
        System.out.println(offer28.isSymmetric(root));
    }

}
