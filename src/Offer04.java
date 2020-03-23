public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        暴力遍历，时间复杂度为O(n*n)，空间复杂度为O(i)
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == target)
//                    return true;
//            }
//        }
//        return false;

//        2、找出子区间
//        if (matrix.length == 0) {
//            return false;
//        }
//        int row = 0;
//        int col = 0;
//        for (int i = matrix[0].length - 1; i >= 0; i--) {
//            if (matrix[0][i] == target) {
//                return true;
//            } else if (matrix[0][i] < target) {
//                col = i;
//                break;
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            if (matrix[i][col] == target) {
//                return true;
//            } else if (matrix[i][col] > target) {
//                row = i;
//                break;
//            }
//        }
//
//        for (int i = row; i < matrix.length; i++) {
//            for (int j = 0; j < col + 1; j++) {
//                if (matrix[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 19;
        Offer04 offer04 = new Offer04();
        System.out.println(offer04.findNumberIn2DArray(matrix, target));
    }
}

