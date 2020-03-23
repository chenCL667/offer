public class Offer13 {
    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        int pathLength = dfs(0, 0, k, m, n, visited);
        return pathLength;
    }

    private int dfs(int row, int col, int k, int m, int n, int[][] visited) {
//        边界判断
        if (row < 0 || row >= m || col < 0 || col >= n) return 0;

//        已经访问过的位置不能再访问
        if (visited[row][col] == 1) return 0;

//        判断该格子机器人是否能走
        if (!canMove(row, col, k)) return 0;

//        排除完上述条件，说明该位置是可以访问的
        visited[row][col] = 1;

        return 1 + dfs(row - 1, col, k, m, n, visited) +
                dfs(row + 1, col, k, m, n, visited) +
                dfs(row, col - 1, k, m, n, visited) +
                dfs(row, col + 1, k, m, n, visited);
    }

    boolean canMove(int row, int col, int k) {
        int sum = 0;
        while (row != 0) {
            sum += (row % 10);
            row /= 10;
        }

        while (col != 0) {
            sum += (col % 10);
            col /= 10;
        }
        return (sum <= k);
    }
}
