public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;
        return isSame(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

//    A树和B树结构一样
    private boolean isSame(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val == B.val) {
            return isSame(A.left, B.left) && isSame(A.right, B.right);
        }
        return false;
    }
}
