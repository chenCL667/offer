public class Offer12 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
//        边界判断
        if (i >= board.length || i < 0 || j < 0 || j >= board[i].length) return false;
        if (k < word.length() && board[i][j] != word.charAt(k)) return false;

//        终止条件判断
        if (k == word.length() - 1) return true;

        char tmp = board[i][j];
        board[i][j] = '/';
//        深搜
        boolean res = dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i, j - 1, k + 1) ||
                dfs(board, word, i, j + 1, k + 1);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'a'},{'a'}};
        String word = "aaa";
        Offer12 offer12 = new Offer12();
        System.out.println(offer12.exist(board, word));
    }
}
