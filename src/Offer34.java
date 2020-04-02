import java.util.ArrayList;
import java.util.List;

public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, lists, sum, list);
        return lists;
    }

    private void dfs(TreeNode root, List<List<Integer>> lists, int sum, List<Integer> list) {
        list.add(root.val);
//        if (sum - root.val < 0) return;
        if (sum - root.val == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList(list));
            return;
        }

        if (root.left != null) {
            dfs(root.left, lists, sum - root.val, list);
            if (!list.isEmpty())
                list.remove(list.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, lists, sum - root.val, list);
            if (!list.isEmpty())
                list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
//        [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode root = new TreeNode(-2);
//        root.left = new TreeNode(4);
        root.right = new TreeNode(-3);

//        root.left.left = new TreeNode(11);
//        root.left.right = null;
//
//        root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(4);
//
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);

        Offer34 offer34 = new Offer34();
        System.out.println(offer34.pathSum(root, -5));
    }

}
