/**
 * 给定的二叉树，将其变换为源二叉树的镜像
 * <p>
 * 二叉树的镜像定义：源二叉树
 * <p>
 * 8
 * <p>
 * /  \
 * <p>
 * 6   10
 * <p>
 * / \  / \
 * <p>
 * 5  7 9 11
 * <p>
 * 镜像二叉树
 * <p>
 * 8
 * <p>
 * /  \
 * <p>
 * 10   6
 * <p>
 * / \  / \
 * <p>
 * 11 9 7  5
 */
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int x ) {
        this.val = x;
    }
}

public class Solution {
    public TreeNode getMinorTree(TreeNode root) {
        if (root == null) return null;
        minTree(root);
        return root;
    }

    private void minTree(TreeNode root) {
        if (root == null) return;
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        minTree(root.left);
        minTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
//        root.left = new TreeNode(6);
//        root.right = new TreeNode(10);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(11);

        Solution solution = new Solution();
        solution.getMinorTree(root);

    }
}
