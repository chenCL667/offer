import java.util.*;

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
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> layer = new ArrayList<Integer>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode end = root;
        while (!queue.isEmpty()) {
            root = queue.poll();
            layer.add(root.val);

            if (root.left != null) queue.offer(root.left);
            if (root.right != null) queue.offer(root.right);
            if (root == end) {
                end = queue.peekLast();
                list.add(layer);
                layer = new ArrayList<Integer>();
            }
        }

        return list;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode end = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            root = deque.poll();
            list.add(root.val);
            if (root.left != null) deque.offer(root.left);
            if (root.right != null) deque.offer(root.right);
            if (end == root) {
                end = deque.peekLast();
                lists.add(list);
                list = new ArrayList<>();
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c));

        Integer nums1 = 189;
        nums1++;
        System.out.println(nums1);

        double x = (-123.45);
        assert x >= 0;
        System.out.println(x);

    }

}

