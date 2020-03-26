import java.util.ArrayList;
import java.util.List;

public class Offer29 {
//    解法1：递归实现，但是比较混乱
//    int[][] visited;
//
//    public int[] spiralOrder(int[][] matrix) {
//        if (matrix == null) return null;
//        if (matrix.length == 0) return null;
//        int[] res = new int[matrix.length * matrix[0].length];
//        visited = new int[matrix.length][matrix[0].length];
//        printNum(matrix, 0, 0, res, 0);
//        return res;
//    }
//
//    private void printNum(int[][] matrix, int i, int j, int[] res, int index) {
//        if (i + 1 > matrix.length / 2 + (matrix.length % 2)) return;
//        int tmpi = i;
//        int tmpj = j;
//        for (; tmpj < matrix[j].length - j; tmpj++) {
//            if (visited[i][tmpj] == 1) break;
//            res[index++] = matrix[i][tmpj];
//            visited[i][tmpj] = 1;
//            System.out.println(matrix[i][tmpj]);
//        }
//        for (tmpi = tmpi + 1; tmpi < matrix.length - i; tmpi++) {
//            if (visited[tmpi][tmpj - 1] == 1) break;
//            res[index++] = matrix[tmpi][tmpj - 1];
//            visited[tmpi][tmpj - 1] = 1;
//            System.out.println(matrix[tmpi][tmpj - 1]);
//        }
//        for (tmpj = tmpj - 2; tmpj >= j; tmpj--) {
//            if (visited[tmpi - 1][tmpj] == 1) break;
//            res[index++] = matrix[tmpi - 1][tmpj];
//            visited[tmpi - 1][tmpj] = 1;
//            System.out.println(matrix[tmpi - 1][tmpj]);
//        }
//        for (tmpi = tmpi - 2; tmpi > i; tmpi--) {
//            if (visited[tmpi][tmpj + 1] == 1) break;
//            res[index++] = matrix[tmpi][tmpj + 1];
//            visited[tmpi][tmpj + 1] = 1;
//            System.out.println(matrix[tmpi][tmpj + 1]);
//        }
//        if (check())
//            printNum(matrix, i + 1, j + 1, res, index);
//    }
//
//    private boolean check(){
//        for (int i = 0; i < visited.length; i++) {
//            for (int j = 0; j < visited[i].length; j++) {
//                if (visited[i][j] == 0) return true;
//            }
//        }
//        return false;
//    }

    //    解法2：借鉴自https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0, buttom = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;

        while (true) {
            for (int i = left; i <= right; i++) res[index++] = matrix[top][i];
            if (++top > buttom) break;

            for (int i = top; i <= buttom; i++) res[index++] = matrix[i][right];
            if (--right < left) break;

            for (int i = right; i >= left; i--) res[index++] = matrix[buttom][i];
            if (--buttom < top) break;

            for (int i = buttom; i >= top; i--) res[index++] = matrix[i][left];
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        Offer29 offer29 = new Offer29();
        for (int e : offer29.spiralOrder(matrix)) {
            System.out.println(e);
        }
    }
}
