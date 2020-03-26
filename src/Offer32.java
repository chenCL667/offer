import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> layer = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (root == queue.peek()) {
                root = queue.poll();
                if (layer.size() != 0)
                    list.add(layer);
                layer = new ArrayList<Integer>();
            }
            root = queue.poll();
            layer.add(root.val);

            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
            if (root.right != null) queue.offer(root.right);
        }

        return list;
    }
}
