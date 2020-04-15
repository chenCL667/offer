/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

public class Offer07 {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        TreeNode root = new TreeNode(preorder[0]);
//        build(preorder, inorder, root);
//        return root;
//    }
//
//    public void build(int[] preorder, int[] inorder, TreeNode treeNode) {
//        if (preorder.length == 0 || inorder.length == 0 || preorder == null)
//            return;
//
//        int index = 0;
//        while (index < inorder.length) {
//            if (inorder[index++] == preorder[0]) break;
//        }
//
//        index--;
//        System.out.println("index = " + index);
//        int[] pre_left = new int[index];
//        int[] in_left = new int[index];
//        int[] pre_right = new int[inorder.length - index - 1];
//        int[] in_right = new int[inorder.length - index - 1];
//
//        int begin = 0;
//        while (begin < index) {
//            pre_left[begin] = preorder[begin + 1];
//            in_left[begin] = inorder[begin];
//            begin++;
//        }
//
//        begin = 0;
//        while ((begin + index + 1) < inorder.length) {
//            pre_right[begin] = preorder[begin + index + 1];
//            in_right[begin] = inorder[begin + index + 1];
//            begin++;
//        }
//
//        if (pre_left.length != 0){
//            treeNode.left = new TreeNode(pre_left[0]);
//            build(pre_left, in_left, treeNode.left);
//        }
//
//        if (pre_right.length!=0){
//            treeNode.right = new TreeNode(pre_right[0]);
//            build(pre_right, in_right, treeNode.right);
//        }
//    }

    //    改进与优化
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public TreeNode build(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map map) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        if (preorderStart == preorderEnd) return root;
        else {
            int index = (int) map.get(preorder[preorderStart]);
            int leftNode = index - inorderStart;
            root.left = build(preorder, preorderStart + 1, preorderStart + leftNode, inorder, inorderStart, inorderStart + leftNode - 1, map);
            root.right = build(preorder, preorderStart + leftNode + 1, preorderEnd, inorder, index + 1, inorderEnd, map);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Offer07 offer07 = new Offer07();
        offer07.buildTree(preorder, inorder);
    }
}
















